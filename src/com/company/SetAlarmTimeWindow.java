package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SetAlarmTimeWindow {
    public static void SetTime ()
    {
        Stage stage = new Stage();
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(15);
        Pane commonPane  = new Pane();

        Label textHrs = new Label("Введите часы:");
        Label TextMin = new Label("Введите минуты:");
        Spinner <Integer> Hours = new Spinner <Integer>(0,23,8);
        Spinner <Integer> Minutes = new Spinner <Integer>(0,59,30);
        Button ok = new Button("Oк");
        commonPane.getChildren().add(ok);

        pane.setHalignment(textHrs, HPos.RIGHT);
        pane.setHalignment(TextMin, HPos.RIGHT);

        pane.add(textHrs,1,0);
        pane.add(TextMin,1,1);
        pane.add(Hours,2,0);
        pane.add(Minutes,2,1);
        commonPane.getChildren().add(pane);
        ok.setLayoutX(310);
        ok.setLayoutY(165);

        stage.setTitle("Выбор времени");
        Scene sceneHelp = new Scene(commonPane, 350, 200);
        if(!Main.profiles_get_theme())
        {
            commonPane.setStyle("-fx-background-color: #200f33");
            ok.setTextFill(Color.LIGHTGREY);
            ok.setStyle("-fx-background-color: #40334a");
            textHrs.setTextFill(Color.web("#d1cbd6"));
            TextMin.setTextFill(Color.web("#d1cbd6"));

        }
        if(Main.profiles_get_theme())
        {
            commonPane.setStyle("-fx-background-color: #f1f0f7");
            ok.setTextFill(Color.web("#27203b"));
            ok.setStyle("-fx-background-color: #b3afc4");
            textHrs.setTextFill(Color.web("#27203b"));
            TextMin.setTextFill(Color.web("#27203b"));

        }


        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close ();
                //
            }
        });

        //прописать привязку спиннеров к созданному профилю




        stage.getIcons().add(new Image("file:ora.png"));
        stage.setScene(sceneHelp);
        stage.setResizable(false);
        stage.showAndWait();
    }
}
