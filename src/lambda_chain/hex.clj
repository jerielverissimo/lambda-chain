(ns lambda-chain.hex 
  (:require
    [clojure.string :as str]))

(def hex-value {:0 0
                :1 1
                :2 2
                :3 3
                :4 4
                :5 5
                :6 6
                :7 7
                :8 8
                :9 9
                :a 10
                :b 11
                :c 12
                :d 13
                :e 14
                :f 15})

(defn hex-to-reverse-keyword-vector
  "Convert a hex string to a reverse keyword vector"
  [hex]
  (->> (str/lower-case hex)
       reverse
       (map str)
       (map keyword)
       vec))

(defn hex-to-decimal
  "Calculate the decimal value of a given hex-string"
  [hex]
  (->> (for [x (map-indexed vector (hex-to-reverse-keyword-vector hex))]
         (->> (* ((second x) hex-value)
                 (.pow 16M (first x)))))
       (reduce +)))
