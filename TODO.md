# TODO

* API key is in code when calling dark sky API, extract this somewhere more sensible
* Weather reporter should use a more human friendly percentage rather than decimal
* JSON parsing uses large chains of (get val key), a function that takes in the path to the relevant data as a list of string could be made for more readable code
* Should test the function that parses the Dark sky API response more by mocking API responses and checking the correct values are extracted