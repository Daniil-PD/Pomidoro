package com.company;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;


public class windowTest {
    public static void windw (String str, String title)
    {
        Stage wnStage = new Stage();
        wnStage.initModality(Modality.APPLICATION_MODAL); // блокировка просмотра основного окна
        Label text = new Label(str);

        Button Ok = new Button("Oк");
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));

        pane.setBottom(Ok);
        BorderPane.setAlignment(Ok, Pos.TOP_RIGHT);
        pane.setCenter(text);
        BorderPane.setAlignment(text, Pos.CENTER);
        text.setFont(new Font("Arial", 30));


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


        Ok.setPadding(new Insets(5, 5, 5, 5));
        Ok.setOnAction(event -> wnStage.close());
        Scene sceneHelp = new Scene(pane, 300, 200);
        wnStage.getIcons().add(new Image("file:kra.png"));
        wnStage.setScene(sceneHelp);
        wnStage.setTitle(title);
        wnStage.setResizable(false);
        wnStage.showAndWait();
    }
    public static void ringMess  ()
    {
        AudioClip plonkSound = new AudioClip(new File("rin.mp3").toURI().toString());
        plonkSound.play();
    }
}
