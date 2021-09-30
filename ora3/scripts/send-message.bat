curl --location --request POST "http://localhost:8081/send-message" ^
--header "Content-Type: application/json" ^
--data-raw "{ \"from\": \"me\", \"message\": \"nothing important\" }"

pause