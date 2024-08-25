package observer_pattern.practice;

public class main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        if (args.length > 0) {
            String city = args[0];
            String token = args[1];
            System.out.println("City received: " + city);
            System.out.println("Token received: " + token);
            weatherData.setCity(city);
            weatherData.setToken(token);
        } else {
            System.out.println("No token provided. Please provide a token as an argument.");
        }

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsdisplay = new StatisticsDisplay(weatherData);
        ForcastDisplay forecastDisplay = new ForcastDisplay(weatherData);

        weatherData.fetchAndSetMeasurements();
//        weatherData.setMeasurements(80, 65, 30.4f);
//        weatherData.setMeasurements(82, 70, 29.2f);
//        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
