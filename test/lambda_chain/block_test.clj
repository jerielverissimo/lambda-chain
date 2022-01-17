(ns lambda-chain.block-test
  (:require [clojure.test :refer [deftest is testing]]
            [lambda-chain.block :as SUT]
            [lambda-chain.hex :refer [hex-to-decimal]]))

(deftest create-a-block-test
  (testing "should return a new Block instance"
    (let [sut (SUT/new-block "dummy")
          sut (merge sut {:hash (deref (get sut :hash))
                          :nonce (deref (get sut :nonce))})]
      (is (= sut 
             {:hash
              "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"
              :nonce 0
              :data "dummy"}))))

  (testing "should return a stringfy a given block"
    (is (= (str (SUT/new-block "dummy")) 
           "dummy0"))))

(deftest mining-a-block-test
  (testing "should mine a given block"
    (let [block (SUT/new-block "dummy")]
      (SUT/mine! block 1)
      (is (= (hex-to-decimal (deref (get block :hash)))
             19031025486724076987226954112297991357750925544680526166142749004221188892982M))
      (is (= (deref (get block :nonce))
             4))
      (is (= (get block :data)
             "dummy")))))


