package com.company;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class HelpWindow {
    public static void newHelpWindow (String title)
    {
        Stage HelpWinStage = new Stage();
        HelpWinStage.initModality(Modality.APPLICATION_MODAL); // блокировка просмотра основного окна



        Pane root = new Pane();
        BorderPane ButtonOK = new BorderPane();
        ButtonOK.setMinSize(360,250);
        ButtonOK.setPadding(new Insets(10,10,10,10));

        DropShadow tenn = new DropShadow();
        Label AboutApp = new Label("Приложение представляет собой таймер, будильник,  секундомер и помодоро. Помодоро - это техника управления временем, предполагающая фиксированное разбиение "
                + " времени на выполнение задач и на перерыв между их выполнением.");
        AboutApp.setMaxWidth(320);
        AboutApp.setWrapText(true);
        Label Who = new Label("Выполнили:\nСтуденты ИАИТ 2-го курса 3-4 группы: Петренко Д., Панарин В., Глыбина Е., Старостин Р.");
        Who.setMaxWidth(320);
        Who.setWrapText(true);






        ButtonOK.setTop(AboutApp);
        BorderPane.setAlignment(AboutApp,Pos.CENTER);
        ButtonOK.setCenter(Who);

        Button Ok = new Button("Oк");
        Ok.setPadding(new Insets(5, 5, 5, 5));
        ButtonOK.setBottom(Ok);
        BorderPane.setAlignment(Ok, Pos.TOP_RIGHT);
        Ok.setEffect(tenn);
        root.getChildren().add(ButtonOK);


        Ok.setOnAction(event -> HelpWinStage.close());
        HelpWinStage.setTitle("Создать профиль");
        Scene sceneHelp = new Scene(root, 360, 250);

        if(!Main.profiles_get_theme())
        {

            root.setStyle("-fx-background-color: #200f33");
            Ok.setTextFill(Color.LIGHTGREY);
            Ok.setStyle("-fx-background-color: #40334a");
            AboutApp.setTextFill(Color.web("#d1cbd6"));
            Who.setTextFill(Color.web("#d1cbd6"));
        }
        if(Main.profiles_get_theme())
        {
            root.setStyle("-fx-background-color: #f1f0f7");
            Ok.setTextFill(Color.web("#27203b"));
            Ok.setStyle("-fx-background-color: #b3afc4");
            AboutApp.setTextFill(Color.web("#27203b"));
            Who.setTextFill(Color.web("#27203b"));
        }



        HelpWinStage.getIcons().add(new Image("file:fre.png"));
        HelpWinStage.setScene(sceneHelp);
        HelpWinStage.setTitle(title);
        HelpWinStage.setResizable(false);
        HelpWinStage.showAndWait();
    }
}
