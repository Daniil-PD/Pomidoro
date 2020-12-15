package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;

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
        TextField search = new TextField();
        FlowPane groupOfFuncts = new FlowPane(search, changeProf, delProf);


        tableView.getColumns().addAll(nameColumn,minWorkTimer, minRestTimer);
        FlowPane root = new FlowPane(tableView, groupOfFuncts);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        for (one_profile G : Main.profiles_get_list())
        {
            ObservableList<one_profile> data = FXCollections.observableArrayList();

        }

        Scene sceneReview = new Scene(root,470, 290);

        sceneReview.getStylesheets().add("file:DarkStyle.css");
        root.setStyle("-fx-background-color: #200f33");
        changeProf.setTextFill(Color.LIGHTGREY);
        changeProf.setStyle("-fx-background-color: #40334a");
        delProf.setTextFill(Color.LIGHTGREY);
        delProf.setStyle("-fx-background-color: #40334a");
        nameColumn.setStyle("#d1cbd6");//+-


        stageProf.getIcons().add(new Image("file:polzovatel.png"));
        stageProf.setScene(sceneReview);
        stageProf.setTitle(title);
        stageProf.setResizable(false);
        stageProf.showAndWait();

    }
}
