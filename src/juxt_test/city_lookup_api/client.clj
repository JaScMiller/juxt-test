(ns juxt-test.city-lookup-api.client
    (:require [clj-http.client :as client]))

(defn call-cities-api
    "Will call the city API and return the results"
    []
    (client/get "https://raw.githubusercontent.com/lutangar/cities.json/master/cities.json" {:as :json}))

(defn get-city-from-api-response
    "Returns the row corresponding to the searched for city or nil if not found"
    [city, api-response]
    (first (filter (fn [entry] (= city (entry :name))) api-response)))

(defn get-city-details
    "Will get the details of a given city using the API"
    [city]
    (let [response-body ((call-cities-api) :body)]
        (get-city-from-api-response city response-body)))