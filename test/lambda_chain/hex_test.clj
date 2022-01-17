(ns lambda-chain.hex-test
  (:require [clojure.test :refer [deftest is testing]]
            [lambda-chain.hex :refer [hex-to-reverse-keyword-vector
                                      hex-to-decimal]]))

(deftest convert-hex-to-decimal-test
  (testing "should return reversed vector of keywords from string received"
    (is (= (hex-to-reverse-keyword-vector "ABCDEF") 
           [:f :e :d :c :b :a])))

  (testing "should return decimal number when an hexdecimal string is received"
    (is (= (hex-to-decimal "5B3E") 
           23358M))))

