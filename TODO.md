# TODO

## Very important

* Decide what to do when there are multiple cities with the same name
* City lookup should be case insensitive
* Need more tests for the hottest day feature, ran out of time on technical test

## Less important

* API key is in code when calling dark sky API, extract this somewhere more sensible
* Weather reporter should use a more human friendly percentage rather than decimal
* JSON parsing uses large chains of (get val key), a function that takes in the path to the relevant data as a list of string could be made for more readable code
* Should test the function that parses the Dark sky API response more by mocking API responses and checking the correct values are extracted
* The main function should be split apart into smaller functions to make it more readable