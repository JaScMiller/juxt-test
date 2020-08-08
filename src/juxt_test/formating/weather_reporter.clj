(ns juxt-test.formating.weather-reporter)

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
