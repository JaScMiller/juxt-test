(ns juxt-test.dark-sky-api.client-test
  (:require [clojure.test :refer :all]
            [juxt-test.dark-sky-api.client :refer :all]))

(deftest call-dark-sky-api-tests
  (testing "able to call the dark sky api"
    (is (= 40 (get (get (call-dark-sky-api 40 -100) :body) :latitude)))))

(deftest get-summaries-from-dark-sky-response-tests
  (testing "able to call the dark sky api"
    (is (map? (get-summaries-from-dark-sky-response (call-dark-sky-api 40 -100))))))