# weather-detector-demo
A Spring Boot REST service calls the OpenWeatherMap API to determine if it is currently snowing or if it is forecasted to snow in the next five days.

## Configuration and Installation
In src/main/java/com/nwarz/weather/Config.java :
* Set the LAT and LON values to the latitude and longitude of your location
* Set the APP_ID to your OpenWeatherMap API key (free tier API keys can be registered for at https://openweathermap.org/price)

Run ```./gradlew bootJar``` to produce an Spring Boot jar in build/libs

This jar can be run on the target server with ```java -jar ./weather-detector-demo-0.1.0.jar```
