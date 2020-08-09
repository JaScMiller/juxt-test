(ns juxt-test.dark-sky-api.client-test
  (:require [clojure.test :refer :all]
            [juxt-test.dark-sky-api.client :refer :all]))

(deftest call-dark-sky-api-tests
  (testing "able to call the dark sky api"
    (is (= 40 (get (get (call-dark-sky-api 40 -100) :body) :latitude)))))

(deftest get-summaries-from-dark-sky-response-tests
  (testing "able to call the dark sky api"
    (is (map? (get-summaries-from-dark-sky-response (call-dark-sky-api 40 -100))))))

(deftest get-sumaries-for-lat-lng-tests
  (testing "can find and parse data from the API"
    (let [result (get-sumaries-for-lat-lng 40 -100)]
      (is (contains? result :currentlySummary)
      (is (contains? result :hourlySummary)
      (is (contains? result :precipProbability)))))))
    
    

