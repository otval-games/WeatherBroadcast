package com.example.weatherbroadcast.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    public ComboBox citySelector;

    @FXML
    public Label cityName;

    @FXML
    public Label cityTemp;

    @FXML
    public ImageView weatherImg;
}