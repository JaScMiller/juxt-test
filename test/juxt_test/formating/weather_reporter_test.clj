(ns juxt-test.formating.weather-reporter-test
  (:require [clojure.test :refer :all]
            [juxt-test.formating.weather-reporter :refer :all]))

(deftest report-weather-tests
  (testing "report-weather formats correctly"
    (is (= "Current weather - sunny, today we will see - more sun with a 0.12 chance of rain" (report-weather "sunny" "more sun" 0.12)))))