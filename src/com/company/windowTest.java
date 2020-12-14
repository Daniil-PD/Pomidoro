package com.company;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class windowTest {
    public static void windw (String str)
    {
        Stage wnStage = new Stage();
        wnStage.initModality(Modality.APPLICATION_MODAL); // блокировка просмотра основного окна
        Label text = new Label(str);

        Button Ok = new Button("Oк");
        BorderPane pane = new BorderPane();
        pane.setBottom(Ok);
        pane.setTop(text);
        BorderPane.setAlignment(Ok, Pos.TOP_RIGHT);
        Media sound = new Media(new File("ring.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        if (!Main.profiles_get_theme())
        {
            pane.setStyle("-fx-background-color: #200f33");
            Ok.setTextFill(Color.LIGHTGREY);
            Ok.setStyle("-fx-background-color: #40334a");
        } else
        {
            pane.setStyle("-fx-background-color: #f1f0f7");
            Ok.setTextFill(Color.web("#27203b"));
            Ok.setStyle("-fx-background-color: #b3afc4");
        }



        Ok.setOnAction(event -> wnStage.close());
        Scene sceneHelp = new Scene(pane, 300, 200);
        wnStage.setScene(sceneHelp);
        wnStage.setResizable(false);
        wnStage.showAndWait();
    }
}
