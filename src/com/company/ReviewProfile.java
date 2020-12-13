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
       /* Stage stageProf = new Stage();
        stageProf.initModality(Modality.APPLICATION_MODAL); // блокировка просмотра основного окна

        TableView<one_profile> tableView = new TableView<one_profile>();
        tableView.setPrefSize(450,250);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TableColumn<one_profile, String> nameColumn = new TableColumn<one_profile, String>("Название профиля");
        //  nameColumn.setCellValueFactory(new PropertyValueFactory<one_profile, String>("name_profile"));//проинициализировать ИМЯ

        TableColumn<one_profile, Boolean> themeNow = new TableColumn<one_profile, Boolean>("Тема по умолчанию");

        TableColumn<one_profile, Integer> PomidColumn = new TableColumn<one_profile, Integer>("Настройки помодоро");

        TableColumn<one_profile, Integer> minWorkTimer = new TableColumn<one_profile, Integer>("Минуты основного таймера");

        TableColumn<one_profile, Integer> minRestTimer = new TableColumn<one_profile, Integer>("Минуты таймера отдыха");
        PomidColumn.getColumns().addAll(minWorkTimer,minRestTimer);



        Button changeProf = new Button("Сменить профиль");
        Button delProf = new Button("Удалить профиль");
        TextField search = new TextField();
        FlowPane groupOfFuncts = new FlowPane(search, changeProf, delProf);



        tableView.getColumns().add(nameColumn);
        FlowPane root = new FlowPane(tableView, groupOfFuncts);


        Scene sceneReview = new Scene(root,470, 290);
        stageProf.setScene(sceneReview);
        stageProf.setTitle(title);
        stageProf.setResizable(false);
        stageProf.showAndWait();*/
    }
}
