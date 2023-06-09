# <h1 align="center">Akbank Bootcamp Final Case</h1>

## Project Details

- A weather application has been written. This application provides weather forecasts using a RESTful web service. It allows users to query weather forecasts for a city. 
Forecasts are obtained in 3-hour intervals covering a period of 5 days. The application obtains weather forecasts using the OpenWeatherMap API.

## Technologies
- Backend = Java Spring Boot
- Api = Openweathermap
- Database = PostgreSQL
- Streaming platform = Apache Kafka

## Project Requirements
- Restful web service: It will receive city and other parameters and provide weather forecast.✔️
- Database: A database system will be used to store the cities and forecasts that users search for.✔️
- Daily forecasts: Weather forecasts will be provided at 3-hour intervals covering a 5-day period.✔️
- User registration: Users can register their cities by creating an account and view weather forecasts for the registered cities.✔️
- API usage: The OpenWeatherMap API will be used to provide weather forecasts.✔️
- Testing: Automated tests will be written to ensure code quality and performance.✔️
- Documentation: Documentation of the RESTful service will be provided using tools like Swagger or OpenApi.✔️
- Logs: A logging mechanism will be set up to help debug the application.✔️

## Swagger Screenshots
### Controller
![swagger1](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/82af8246-bbe7-4dc8-8bda-dd7a255d7f47)
### Register User
![Done-r](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/e062bccc-fa2f-49d4-a81f-b1d712b16853)
![Ekran görüntüsü 2023-06-08 214033](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/f8bbd703-3073-45aa-a161-3a73bc8b13d3)
### Incorrect Login Authenticate
![Ekran görüntüsü 2023-06-08 214310](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/057f5834-13f0-4831-9495-a51bbcc8140a)
![Ekran görüntüsü 2023-06-08 214513](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/64854cb9-42fa-486f-af65-5c28eb8fbdc0)
### Correct Login Authenticate
![Ekran görüntüsü 2023-06-09 151930](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/51c70c5a-5339-4414-bcba-b72544d7048c)
![Ekran görüntüsü 2023-06-08 214751](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/12c47594-c801-439e-b605-9e1ef9c1b13b)
### JWT
![auth](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/1053f460-7f70-44b8-876b-55865d34c8fc)
### Get User
![Ekran görüntüsü 2023-06-08 215348](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/8ebf849c-6a55-4288-a9b5-ee2b828c0a4b)
![Doonekran görüntüsü 2023-06-08 213436](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/96149c6d-fc33-4816-89ca-5d53cebcb858)
### Get User and Saved City Weather
![Ekran görüntüsü 2023-06-08 213403](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/bd11afa7-bc07-4888-8efb-c812f7f7ed77)
![Ekran görüntüsü 2023-06-08 213422](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/11b1d05f-906c-4391-b623-53a9a40bec7f)
### Get City Weather
![Ekran görüntüsü 2023-06-08 215440](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/16c69701-0694-47b4-8eba-109ac10b1f62)
![Ekran görüntüsü 2023-06-08 215457](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/de5d0f36-90bf-4c02-9ae2-55c2fcb952ad)
### Kafka Log Info
![authLog](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/396f8f32-f316-44fd-a000-bbbedaec3a69)
![Ekran görüntüsü 2023-06-08 213506](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/8b8e4688-4400-44ba-8062-7406bcaf92cf)
![Ekran görüntüsü 2023-06-08 213520](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/37aca83b-028f-4ee1-b68b-2ead2eb0cf70)
### Test
![Ekran görüntüsü 2023-06-08 213642](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/d90e71c0-612e-420c-8aea-3e8049d3d69f)

