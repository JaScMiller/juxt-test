(ns juxt-test.core
  (:gen-class)
  (:require [juxt-test.city-lookup-api.client :refer :all]
            [juxt-test.dark-sky-api.client :refer :all]
            [juxt-test.formating.weather-reporter :refer :all]))

(defn -main
  [& [input-city]]
  (let [city (if input-city input-city "")]
    (let [city-details (get-city-details city)]
      (if city-details
        (let [weather-data (get-summaries-from-dark-sky-response (call-dark-sky-api (city-details :lat) (city-details :lng)))]
          (let [weather-report (report-weather (get weather-data :currentlySummary) (get weather-data :hourlySummary) (get weather-data :precipProbability))]
            (println weather-report)))
        (println (str "No results found" (if input-city (str " for " input-city) "") "."))))))