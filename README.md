# Kry Code Assignment (Service Poller)
## How to run the Application 
It's online at the following link on Heroku

https://kry-services-frontend.herokuapp.com/

the UI will show the list of services if their is any present in the database or you can add few services and it will display the list

## Details about the functionality
- This App will show the list of services and their urls added to the database. It will show following fields
  - Name of the service
  - URl of the service
  - Date and Time when the services were added to the list
  - OK or FAIL status of the service.
- The App will do the polling on eachservice in the list by hitting their urls and store their status (OK if status is 200 else FAIL status)
- Services can be added, deleted and updated.
- The Application also fetches data from the api using axios GET request in every 60 secs.
