(ns juxt-test.formating.weather-reporter
    (:require [clj-time.coerce :as c])
    (:require [clj-time.format :as f]))

(defn report-weather
    "Takes in a current summary, an hourly summary, and a precip probability
    and then outputs a formatted weather report"
    [cs hs pp]
    (str "Current weather - "
         cs
         ", today we will see - "
         hs
         " with a "
         pp
         " chance of rain"))

(defn find-hottest-day-timestamp
    "Will find the hottest day out of the list passed"
    [days]
    (let [maxTemperature (apply max (map (fn [entry] (entry :temperatureMax)) days))]
        ((first (filter (fn [entry] (= (entry :temperatureMax) maxTemperature)) days)) :time)))

(def day-formatter (f/formatter "EEEE"))

(defn find-hottest-day-of-week
    "Will find the hottest day and output as human readable day of the week"
    [days]
    (let [timestamp (find-hottest-day-timestamp days)]
        (f/unparse day-formatter (c/from-long (long (* 1000 timestamp))))))

(defn report-hottest-day
    "Will return a string that reports the hottest day"
    [days]
    (let [day (find-hottest-day-of-week days)]
        (str "This week the hottest day will be " day)))