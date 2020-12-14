package com.company;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
        Ok.setOnAction(event -> wnStage.close());
        wnStage.setTitle("Окошко");
        Scene sceneHelp = new Scene(pane, 300, 200);
        wnStage.setScene(sceneHelp);
        wnStage.setResizable(false);
        wnStage.showAndWait();
    }
}
