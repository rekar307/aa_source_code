package observer_pattern.practice;

public class main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsdisplay = new StatisticsDisplay(weatherData);
        ForcastDisplay forecastDisplay = new ForcastDisplay(weatherData);

        weatherData.fetchAndSetMeasurements();
//        weatherData.setMeasurements(80, 65, 30.4f);
//        weatherData.setMeasurements(82, 70, 29.2f);
//        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
