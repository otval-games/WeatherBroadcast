package com.example.weatherbroadcast.Modules;

import com.example.weatherbroadcast.Controllers.Controller;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javafx.application.Platform;

public class Parser {

    public static void parseJSON(String jsonResponse, String city, Controller controller) throws JSONException {

        JSONObject jsonObject = new JSONObject(jsonResponse);

        JSONArray weatherArray = jsonObject.getJSONArray("weather");
        JSONObject weather = weatherArray.getJSONObject(0);

        JSONObject main = jsonObject.getJSONObject("main");

        double temperature = Math.round(main.getDouble("temp")-273.15);

        double humidity = main.getDouble("humidity");

        JSONObject wind = jsonObject.getJSONObject("wind");
        double windSpeed = wind.getDouble("speed");

        String icon = weather.getString("icon");

        Platform.runLater(() -> {
            controller.city.setText(city);
            controller.temp.setText((temperature)+"°");
            controller.humidity.setText((humidity)+"%");
            controller.windSpeed.setText((windSpeed)+"km/h");
            controller.setWeatherImage(icon);
        });
    }
}