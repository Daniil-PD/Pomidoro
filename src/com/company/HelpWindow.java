package com.company;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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




        root.getChildren().addAll(ButtonOK);


        Ok.setOnAction(event -> HelpWinStage.close());
        HelpWinStage.setTitle("Создать профиль");
        Scene sceneHelp = new Scene(root, 300, 200);
        HelpWinStage.setScene(sceneHelp);
        HelpWinStage.setTitle(title);
        HelpWinStage.setResizable(false);
        HelpWinStage.showAndWait();
    }
}
