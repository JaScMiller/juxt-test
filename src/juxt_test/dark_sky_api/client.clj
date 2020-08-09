(ns juxt-test.dark-sky-api.client
    (:require [clj-http.client :as client]))

(defn call-dark-sky-api
    "Will call the dark sky API and return the results (uses latitude and longitude)"
    [lat long]
    (client/get (str "https://api.darksky.net/forecast/1f9fcb72e6b5d043a34b34bc5f4f86e1/" lat "," long) {:as :json}))

(defn get-summaries-from-dark-sky-response
    "Will parse the json response from dark sky and extract the current and hourly summary, and the daily precip probability"
    [json]
    {:currentlySummary (get (get json :currently) :summary)
     :hourlySummary (get (get json :hourly) :summary)
     :precipProbability (get (get (get (get json :daily) :data) 0) :precipProbability)
     :days (get (get json :daily) :data) })

(defn get-sumaries-for-lat-lng
    "Will call the API and get the summary for the given latitude and longitude"
    [lat lng]
    (let [response-body ((call-dark-sky-api lat lng) :body)]
        (get-summaries-from-dark-sky-response response-body)))
