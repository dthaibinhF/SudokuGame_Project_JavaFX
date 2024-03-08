package com.example.sudokudemo;

import UserInterface.IUserInterfaceContract;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryState) throws IOException {
        uiImpl = new IUserInterfaceImpl(primaryState);
        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}