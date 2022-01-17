(ns lambda-chain.core 
  (:require
    [lambda-chain.block :refer [new-block mine!]]
    [lambda-chain.hex :refer [hex-to-decimal]]))

(def block (new-block "dummy"))

(defn -main
  "I don't do a whole lot."
  [& _]
  (mine! block 1)
  (println (hex-to-decimal (deref (get block :hash))))
  (println (deref (get block :nonce)))
  (println (get block :data)))
