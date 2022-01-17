(ns lambda-chain.block 
  (:require
    [lambda-chain.hex :refer [hex-to-decimal]]
    [pandect.algo.sha256 :refer [sha256]]))

(defrecord Block [hash, nonce, data]
  Object
  (toString [_] (str (str data) (str @nonce))))

(defn new-block [data]
  (->Block (atom (sha256 "")) (atom 0) data))


(defn mine! [block, difficulty]
  (while (> (hex-to-decimal (deref (get block :hash)))
            (.pow 2M (- 256 difficulty)))
    (do
      (swap! (get block :nonce) inc)
      (swap! (get block :hash) (fn [h] (sha256 (.getBytes (str h) "UTF-8")))))))
