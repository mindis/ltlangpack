(ns web.tm-nlp
  (:require [opennlp.nlp :refer :all]))

(def get-sentences (make-sentence-detector "models/lt-sent.bin"))
(def tokenize (make-tokenizer "models/lt-token.bin"))

(defn sentences [text] (get-sentences text))
(defn tokens [text] (get-sentences text))
