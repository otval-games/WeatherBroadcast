package com.example.weatherbroadcast.Modules;

import com.example.weatherbroadcast.Controllers.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    public Request(String city, Controller controller){

        String APIURL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=1d363bc3816d0780818cf2deb3a3d536";

        try {
            URL url = new URL(APIURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = bufferedReader.readLine()) != null) {
                    response.append(inputLine);
                }

                bufferedReader.close();
                System.out.println("Success: "+response);

                Parser.parseJSON(response.toString(), city, controller);

            }else {
                System.out.println("Error: "+responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}