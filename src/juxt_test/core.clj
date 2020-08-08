(ns juxt-test.core
  (:gen-class)
  (:require [juxt-test.dark-sky-api.client :refer :all]
            [juxt-test.formating.weather-reporter :refer :all]))

(defn -main
  [& args]
  (let [weather-data (get-summaries-from-dark-sky-response (call-dark-sky-api 60.59329987 -1.44250533))]
    (let [weather-report (report-weather (get weather-data :currentlySummary) (get weather-data :hourlySummary) (get weather-data :precipProbability))]
      (println weather-report))))
