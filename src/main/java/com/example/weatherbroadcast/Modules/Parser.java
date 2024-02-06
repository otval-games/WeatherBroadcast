package com.example.weatherbroadcast.Modules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

import com.example.weatherbroadcast.Controllers.Controller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Parser {
    private static final String TAG_FILENAME = "forecast.json";
    private final Controller controller;
    private String requestName;

    public Parser(String requestName, Controller controller) {
        this.controller = controller;
        this.requestName=requestName;
    }

    public  void saveJSON(){
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(TAG_FILENAME)){
            gson.toJson(requestName, writer);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public  void uploadJSON() {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(TAG_FILENAME)){

            Type rectType = new TypeToken<String>(){}.getType();
            String result = gson.fromJson(reader, rectType);

            System.out.println("JSON forecast: "+result);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
