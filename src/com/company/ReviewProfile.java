package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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

        //ObservableList<one_profile> list = getList();

        Scene sceneReview = new Scene(root,470, 290);
        stageProf.setScene(sceneReview);
        stageProf.setTitle(title);
        stageProf.setResizable(false);
        stageProf.showAndWait();

    }
}
