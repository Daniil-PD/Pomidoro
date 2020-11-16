package com.company;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddProfile {
    public static void AddProfileWindow (String title)
    {
        Stage NewProfileStage = new Stage();
        Label NameLabel = new Label("Название профиля:");
        TextField NameField = new TextField();
        NameField.setMaxSize(100,5);
        Label ThemeLabel = new Label("Тема по умолчанию:");
        ToggleGroup ThemeButtons = new ToggleGroup();
        RadioButton LightTheme = new RadioButton("Светлая тема");
        RadioButton DarkTheme = new RadioButton("Темная тема");
        LightTheme.setToggleGroup(ThemeButtons);
        DarkTheme.setToggleGroup(ThemeButtons);


        GridPane ProfileGrid = new GridPane();
        ProfileGrid.setPadding(new Insets(20));
        ProfileGrid.setHgap(10);
        ProfileGrid.setVgap(15);
        ProfileGrid.add(NameLabel,0,1);
        ProfileGrid.add(NameField,1,1);
        ProfileGrid.add(ThemeLabel,0,2);
        ProfileGrid.add(LightTheme,1,2);
        ProfileGrid.add(DarkTheme,2,2);
        ProfileGrid.setHalignment(NameLabel, HPos.RIGHT);
        ProfileGrid.setHalignment(ThemeLabel, HPos.RIGHT);





        Label LabelPomodoro = new Label("Помодоро");
        ProfileGrid.add(LabelPomodoro,1,4);
        Label LabelTimer = new Label("Минуты основного таймера:");
        Label LabelRest = new Label("Минуты таймера отдыха:");
        Slider MinuteTimer = new Slider(0,90,45);

        MinuteTimer.setShowTickLabels(true);
        MinuteTimer.setShowTickMarks(true);
        MinuteTimer.setBlockIncrement(17);//перемещение ползунка от 5 до 90
        MinuteTimer.setMajorTickUnit(10); //растояние между 2 значениями
        MinuteTimer.setMinorTickCount(1); //
        MinuteTimer.setSnapToTicks(true);//перемещение ползунка строго по целым значениям
        MinuteTimer.setMinSize(250, 50);


        ProfileGrid.add(LabelTimer,0,5);
        ProfileGrid.add(LabelRest,0,7);
        ProfileGrid.setHalignment(LabelTimer, HPos.CENTER);
        ProfileGrid.setHalignment(LabelRest, HPos.CENTER);
        MinuteTimer.setLayoutX(190);
        MinuteTimer.setLayoutY(150);



        Slider restTimer = new Slider(0,30,15);

        restTimer.setShowTickLabels(true);
        restTimer.setShowTickMarks(true);
        restTimer.setBlockIncrement(17);//перемещение ползунка от 5 до 90
        restTimer.setMajorTickUnit(5); //растояние между 2 значениями
        restTimer.setMinorTickCount(4); //
        restTimer.setSnapToTicks(true);//перемещение ползунка строго по целым значениям
        restTimer.setMinSize(250, 50);
        restTimer.setLayoutX(190);
        restTimer.setLayoutY(200);
        Group AllWindow = new Group();
        AllWindow.getChildren().addAll(ProfileGrid,restTimer,MinuteTimer);

        NewProfileStage.setTitle("Создать профиль");
        Scene NewprofileScene = new Scene(AllWindow, 470, 290);
        NewProfileStage.setResizable(false);
        NewProfileStage.setScene(NewprofileScene);
        NewProfileStage.setTitle(title);
        NewProfileStage.showAndWait();



    }
}
