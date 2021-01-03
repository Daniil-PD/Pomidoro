package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ReviewProfile {
    private final ObservableList<one_profile> tvObservableList = FXCollections.observableArrayList();
    public  static void RevProf (String title)
    {
        Stage stageProf = new Stage();
        stageProf.initModality(Modality.APPLICATION_MODAL);


        TableView<one_profile> tableView = new TableView<one_profile>();
        tableView.setPrefSize(460,250);
        tableView.setLayoutX(4);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TableColumn<one_profile, String> nameColumn = new TableColumn<one_profile, String>("Название");
        TableColumn<one_profile, Integer> minWorkTimer = new TableColumn<one_profile, Integer>("Мин. основного таймера");
        TableColumn<one_profile, Integer> minRestTimer = new TableColumn<one_profile, Integer>("Мин. таймера отдыха");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name_profile"));//проинициализировать ИМЯ
        minWorkTimer.setCellValueFactory(new PropertyValueFactory<>("work_timer"));
        minRestTimer.setCellValueFactory(new PropertyValueFactory<>("rest_timer"));

        Button changeProf = new Button("Сменить профиль");
        Button delProf = new Button("Удалить профиль");
        Button Okey = new Button("Ок");
        TextField search = new TextField();
        HBox groupOfFuncts = new HBox(search, changeProf, delProf,Okey);
        groupOfFuncts.setSpacing(5);
        groupOfFuncts.setMaxWidth(460);
        groupOfFuncts.setAlignment(Pos.TOP_RIGHT);


        tableView.getColumns().addAll(nameColumn,minWorkTimer, minRestTimer);
        ObservableList<one_profile> data = FXCollections.observableArrayList(Main.profiles_get_list());
        tableView.setItems(data);


        VBox root = new VBox(tableView, groupOfFuncts);

        root.setSpacing(5);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Scene sceneReview = new Scene(root,470, 290);

        if (!Main.profiles_get_theme())
        {
            sceneReview.getStylesheets().add("file:DarkStyle.css");
            root.setStyle("-fx-background-color: #200f33");
            changeProf.setTextFill(Color.LIGHTGREY);
            changeProf.setStyle("-fx-background-color: #40334a");
            delProf.setTextFill(Color.LIGHTGREY);
            delProf.setStyle("-fx-background-color: #40334a");
            Okey.setTextFill(Color.LIGHTGREY);
            Okey.setStyle("-fx-background-color: #40334a");
            nameColumn.setStyle("#d1cbd6");//+-
        }
        else
        {
            sceneReview.getStylesheets().add("file:LightStyle.css");
            root.setStyle("-fx-background-color: #f1f0f7");
            changeProf.setTextFill(Color.web("#27203b"));
            changeProf.setStyle("-fx-background-color: #c8cadb");
            delProf.setTextFill(Color.web("#27203b"));
            delProf.setStyle("-fx-background-color: #c8cadb");
            Okey.setTextFill(Color.web("#27203b"));
            Okey.setStyle("-fx-background-color: #c8cadb");
            nameColumn.setStyle("#403b45");//+-
        }


        DropShadow shw = new DropShadow();
        Okey.setEffect(shw);
        delProf.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                changeProf.setEffect(null);
                Okey.setEffect(null);
                delProf.setEffect(shw);
                // что-то ваше
            }
        });
        changeProf.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                delProf.setEffect(null);
                Okey.setEffect(null);
                changeProf.setEffect(shw);
                // что-то ваше
            }
        });
        Okey.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                delProf.setEffect(null);
                Okey.setEffect(shw);
                changeProf.setEffect(null);
                stageProf.close();
                // что-то м.б. ваше
            }
        });
        stageProf.getIcons().add(new Image("file:polzovatel.png"));
        stageProf.setScene(sceneReview);
        stageProf.setTitle(title);
        stageProf.setResizable(false);
        stageProf.showAndWait();

    }
}
