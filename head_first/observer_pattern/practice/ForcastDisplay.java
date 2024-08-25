package observer_pattern.practice;

public class ForcastDisplay implements Observer, DisplayElement {
    private WeatherData weatherData;
    private String weatherMain;
    private String weatherDescription;

    public ForcastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(WeatherData weatherData) {
        this.weatherMain = weatherData.getWeatherMain();
        this.weatherDescription = weatherData.getWeatherDesc();
        display();
    }

    public void display() {
        System.out.println("Today Weather: Main: " + weatherMain + ", Description: " + weatherDescription);
    }
}