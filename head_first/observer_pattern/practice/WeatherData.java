package observer_pattern.practice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> observers;
    private float temp;
    private float tempMin;
    private float tempMax;
    private float humidity;
    private float pressure;
    private String weatherMain;
    private String weatherDesc;

    String apiKey = "2136da88de01e46a534c4b82ee4951bc";
    String cityName = "Seoul";

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temp, float temp_min, float temp_max, float humidity, float pressure, String weatherMain, String weatherDesc) {
        this.temp = temp;
        this.tempMin = temp_min;
        this.tempMax = temp_max;
        this.humidity = humidity;
        this.pressure = pressure;
        this.weatherMain = weatherMain;
        this.weatherDesc = weatherDesc;
        measurementsChanged();
    }

    public void fetchAndSetMeasurements() {
        try {
            String encodedCityName = URLEncoder.encode(cityName, "UTF-8");
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + encodedCityName + "&appid=" + apiKey;
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(5000);  // 5초 타임아웃
            conn.setReadTimeout(5000);     // 5초 타임아웃
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder jsonOutput = new StringBuilder();
            String output;

            while ((output = br.readLine()) != null) {
                jsonOutput.append(output);
            }

            conn.disconnect();

            // JSON 파싱
            JSONObject jsonObject = new JSONObject(jsonOutput.toString());
            JSONObject main = jsonObject.getJSONObject("main");

            float temp = main.getFloat("temp");
            float tempMin = main.getFloat("temp_min");
            float tempMax = main.getFloat("temp_max");
            float humidity = main.getFloat("humidity");
            float pressure = main.getFloat("pressure");
            // Kelvin to Celsius 변환
            temp -= 273.15;
            tempMin -= 273.15;
            tempMax -= 273.15;

            String weatherMain = "";
            String weatherDesc = "";
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject weatherObject = jsonArray.getJSONObject(i);
                int id = weatherObject.getInt("id");
                weatherMain = weatherObject.getString("main");
                weatherDesc = weatherObject.getString("description");
            }

            // 측정값 설정
            setMeasurements(temp, tempMin, tempMax, humidity, pressure, weatherMain, weatherDesc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public float getTempMin() {
        return tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemperature() {
        return temp;
    }
    // etc WeatherData method
}
