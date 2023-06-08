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
![swagger1](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/9cf4d2df-4941-4ff2-b62b-2736f6fc69db)
### Register User
![Ekran görüntüsü 2023-06-08 214020](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/a0c6623e-7774-4e3a-a8f7-1a103232c758)
![Ekran görüntüsü 2023-06-08 214033](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/8cd17ce6-fefb-4552-b482-82a360fd4020)
### Incorrect Login Authenticate
![Ekran görüntüsü 2023-06-08 214310](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/8c35fe96-2ec4-433d-82b1-01b4e74afaba)
![Ekran görüntüsü 2023-06-08 214513](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/e90e8265-8cfa-4d2f-b9b6-6d679515c0ce)
### Correct Login Authenticate
![Ekran görüntüsü 2023-06-08 214624](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/b52afbe4-9c5c-4320-b629-5abea33f7799)
![Ekran görüntüsü 2023-06-08 214751](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/63bcf7b8-efd1-47da-a646-836cedf5ff20)
### JWT
![auth](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/58c4a3cd-27cf-4645-8b9a-2abdcfdf3607)
### Get User
![Ekran görüntüsü 2023-06-08 215348](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/718a23a0-3fcc-46f1-b8d9-d1df04f9f16a)
![Ekran görüntüsü 2023-06-08 213436](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/93f98fc9-8176-4214-87aa-5c7ded66c916)
### Get User and Saved City Weather
![Ekran görüntüsü 2023-06-08 213403](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/f4e9a47a-b370-46c1-a475-f17067c377a1)
![Ekran görüntüsü 2023-06-08 213422](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/ad13b30f-f7ce-4a4d-bf10-a04e903bc8ea)
### Get City Weather
![Ekran görüntüsü 2023-06-08 215440](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/2ff9769d-e0b9-4d43-8fda-941935cff6a0)
![Ekran görüntüsü 2023-06-08 215457](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/caf36c46-7137-4ea2-96a1-6c3508a45e60)
### Kafka Log Info
![Ekran görüntüsü 2023-06-08 213506](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/b8816cb1-ca7d-4ff2-91da-320fa3f845a6)
![Ekran görüntüsü 2023-06-08 213520](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/bf61ac53-88d4-4131-9069-9a71d0e9f0bd)
![authLog](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/2e347f88-59aa-46dc-afd8-a07136cc4963)
### Test
![Ekran görüntüsü 2023-06-08 213642](https://github.com/akaydeliorman/akbankbootcamp_finalcase/assets/101337533/c0208773-e337-436a-bf6f-99f4f4b320db)

