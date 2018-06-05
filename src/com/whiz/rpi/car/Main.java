package com.whiz.rpi.car;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //final TextField screen  = createScreen();
        TextField display = new TextField();
        display.setText("Press any button..");
        display.setAlignment(Pos.CENTER_LEFT);
        display.setEditable(false);
        display.setStyle("-fx-background-color: gray;");


        // Button to move forward
        Button forwardBtn = new Button("Forward");
        forwardBtn.setOnAction(event ->
                display.setText("Moving forward.."));

        // Button to turn left
        Button turnLeftBtn = new Button("Turn Left");
        turnLeftBtn.setOnAction(event ->
                display.setText("Turning left.."));

        // Button to turn right
        Button turnRightBtn = new Button("Turn Right");
        turnRightBtn.setOnAction(event ->
                display.setText("Turning right.."));

        // Button to stop
        Button stopBtn = new Button("Stop");
        stopBtn.setOnAction(event -> display.setText("Stopped.."));

        // Button to move backward
        Button backwardBtn = new Button("Backward");
        //backwardBtn.setShape(new Circle(20,20,10));
        backwardBtn.setOnAction(event -> display.setText("Moving backward.."));

        HBox topDisplayPane = new HBox();
        topDisplayPane.setAlignment(Pos.CENTER);
        topDisplayPane.setPadding(new Insets(15, 12, 15, 12));
        topDisplayPane.setSpacing(10);
        topDisplayPane.getChildren().add(display);

        VBox centerButtonsPane = new VBox();
        centerButtonsPane.setPadding(new Insets(10));
        centerButtonsPane.setSpacing(8);
        centerButtonsPane.getChildren().addAll(forwardBtn,stopBtn,backwardBtn);

        BorderPane border = new BorderPane();
        border.setTop(topDisplayPane);
        border.setLeft(turnLeftBtn);
        border.setCenter(centerButtonsPane);
        border.setRight(turnRightBtn);
        Scene scene = new Scene(border, 300, 250);

        primaryStage.setTitle("Robot Car GUI");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
