package observer_pattern.practice;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float tempMin;
    private float tempMax;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update() {
        this.tempMin = weatherData.getTempMin();
        this.tempMax = weatherData.getTempMax();
        display();
    }

    public void display() {
        System.out.println("Statistics temperature(Min: " + tempMin + ", Max: " + tempMax);
    }
}

