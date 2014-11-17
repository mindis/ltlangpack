(ns web.handler
  (:require [web.tm-nlp :as nlp]
            [compojure.core :refer :all]
            [compojure.handler :as handler]
            [net.cgrand.enlive-html :refer :all]
            [ring.util.response :as resp]
            [ring.middleware.params :as params]
            [compojure.route :as route]))

(def text-input (html-resource "public/input.html"))

(defroutes app-routes
  (GET "/" [] (resp/redirect "/index.html"))
  (GET "/input" [] (emit* text-input))
  (POST "/input" [content]  (first (nlp/get-sentences content)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      params/wrap-params))
