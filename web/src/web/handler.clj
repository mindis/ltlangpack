(ns web.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.util.response :as resp]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] (resp/redirect "/index.html"))
  (GET "/input" [] (resp/redirect "/input.html"))
  (POST "/result" [content])
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
