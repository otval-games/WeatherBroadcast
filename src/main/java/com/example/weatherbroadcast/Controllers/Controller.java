package com.example.weatherbroadcast.Controllers;

import com.example.weatherbroadcast.Modules.Request;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    public TextField cityField;

    @FXML
    public Label humidity;

    @FXML
    public Label windSpeed;

    @FXML
    public Label city;

    @FXML
    public Label temp;

    @FXML
    public ImageView weatherImg;

    public void setWeatherImage(String icon) {
        String imageUrl = "http://openweathermap.org/img/wn/" + icon + ".png";
        Image image = new Image(imageUrl);
        weatherImg.setImage(image);
    }

    @FXML
    public void onEnterPressed() {
        Request newRequest = new Request(cityField.getText(), this);
    }
}