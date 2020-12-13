package com.company;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
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
        ButtonOK.setMinSize(300,200);
        ButtonOK.setPadding(new Insets(10,10,10,10));


        Label AboutApp = new Label("Приложение представляет собой таймер,\nбудильник,  секундомер и помодоро. " +
                "\nПомодоро - это техника управления \nвременем, предполагающая фиксированное \nразбиение " +
                " времени на выполнение задач \nи на перерыв между их выполнением.");
        //AboutApp.setWrapText(true); -выравнивание текста не работает!
        //AboutApp.setTextAlignment(TextAlignment.JUSTIFY);



        ButtonOK.setTop(AboutApp);
        BorderPane.setAlignment(AboutApp,Pos.CENTER);

        Button Ok = new Button("Oк");
        Ok.setPadding(new Insets(5, 5, 5, 5));
        ButtonOK.setBottom(Ok);
        BorderPane.setAlignment(Ok, Pos.TOP_RIGHT);
        DropShadow tenn = new DropShadow();
        Ok.setEffect(tenn);
        root.getChildren().addAll(ButtonOK);


        Ok.setOnAction(event -> HelpWinStage.close());
        HelpWinStage.setTitle("Создать профиль");
        Scene sceneHelp = new Scene(root, 300, 200);

        /* Темная тема
        root.setStyle("-fx-background-color: #200f33");
        Ok.setTextFill(Color.LIGHTGREY);
        Ok.setStyle("-fx-background-color: #40334a");
        AboutApp.setTextFill(Color.web("#d1cbd6"));
         */
        /* светлая тема
        root.setStyle("-fx-background-color: #f1f0f7");
        Ok.setTextFill(Color.web("#27203b"));
        Ok.setStyle("-fx-background-color: #b3afc4");
        AboutApp.setTextFill(Color.web("#27203b"));
         */


        HelpWinStage.setScene(sceneHelp);
        HelpWinStage.setTitle(title);
        HelpWinStage.setResizable(false);
        HelpWinStage.showAndWait();
    }
}
