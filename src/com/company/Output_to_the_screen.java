package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Output_to_the_screen {




    public static void start_output_to_the_screen(Stage stage) throws Exception {
        Rectangle ClockZone = new Rectangle(330,200, Color.GAINSBORO); //поле заднего фона часов
        ClockZone.setX(140);
        ClockZone.setY(40);
        Group group = new Group(); //без актеров и сцены не будет спектакля
        MenuBar menuBar = new MenuBar(); // верхняя строка-меню
        Menu menuSettings = new Menu("Настройки"); // добавление менюшек
        Menu menuProfile = new Menu("Профиль");


        Menu menuHelp = new Menu("Справка");
        MenuItem menuHelp1 = new MenuItem("Просмотреть справку...");
        menuHelp1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String musicFile = "Another One Bites The Dust.mp3";     // For example

                Media sound = new Media(new File("Another One Bites The Dust.mp3").toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                HelpWindow.newHelpWindow("Справка");
                mediaPlayer.stop();

            }
        });
        menuHelp.getItems().add(menuHelp1);


        MenuItem DeleteProfile = new MenuItem("Удалить профиль"); // список меню профиля
        /* ТУТ обрабатываем события кнопки DeleteProfile
        DeleteProfile.setOnAction(new EventHandler<ActionEvent>() { // обратите внимание на методы setOn...
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        */
        MenuItem AddProfile1 = new MenuItem("Добавить профиль");
        AddProfile1.setOnAction(event -> AddProfile.AddProfileWindow("Добавление профиля"));
        MenuItem ChangeProfile = new MenuItem("Изменить текущий профиль");
        menuProfile.getItems().addAll(AddProfile1, DeleteProfile, ChangeProfile); // группируем профиль

        RadioMenuItem Lightheme = new RadioMenuItem("Светлая тема"); // список меню настройки
        RadioMenuItem Darktheme = new RadioMenuItem("Темная тема");
        RadioMenuItem autoTheme = new RadioMenuItem("Тема по умолчанию");
        ToggleGroup toggleGroup = new ToggleGroup(); // создаём группу выбора для тем (галочка д.б. только у 1-ой)
        Lightheme.setToggleGroup(toggleGroup); //
        Darktheme.setToggleGroup(toggleGroup);
        autoTheme.setToggleGroup(toggleGroup);
        menuSettings.getItems().addAll(Lightheme, Darktheme, autoTheme); // группируем настройки
        menuBar.getMenus().addAll(menuSettings, menuProfile, menuHelp); // группируем всё меню
        menuBar.setMinWidth(500);
        group.getChildren().add(menuBar);


        // добавляем меню к актёрам
        VBox Settings = new VBox();
        Button Pomodoro = new Button("Помодоро");
        Button Timer = new Button("Таймер");
        Button SecRecorder = new Button("Секундомер");
        Button AlClock = new Button("Будильник");
        Timer.setMaxWidth(100);
        Pomodoro.setMaxWidth(100);
        SecRecorder.setMaxWidth(100);
        AlClock.setMaxWidth(100);
        Settings.getChildren().addAll(Pomodoro, Timer, SecRecorder, AlClock);
        Settings.setPadding(new Insets(30));
        Settings.setSpacing(30);
        Settings.setLayoutY(15);
        Settings.setAlignment(Pos.CENTER);
        group.getChildren().add(ClockZone);
        group.getChildren().add(Settings);
        Text timeText= new Text(Long.toString((Main.pomidoro_get_remaining_time()%1000*60*60*24)/1000*60*60) + ":" +
                Long.toString((Main.pomidoro_get_remaining_time()%1000*60*60)/1000*60) + ":" +
                Long.toString((Main.pomidoro_get_remaining_time()%1000*60)/1000));

        // СЮДА ПОМЕЩАЕМ ВРЕМЯ!
        //Text timeText= new Text(Long.toString(Main.pomidoro_get_remaining_time()));
        timeText.setX(160);
        timeText.setY(160);
        timeText.setFont(new Font(80));
        group.getChildren().add (timeText);


        HBox timeButtons = new HBox();
        Button StartBut = new Button("Старт");
        Button StopBut = new Button("Стоп");
        Button ContinueBut = new Button("Продолжить");
        timeButtons.getChildren().addAll(StartBut, StopBut, ContinueBut);
        timeButtons.setSpacing(25);
        timeButtons.setLayoutX(180);
        timeButtons.setLayoutY(255);
        group.getChildren().add(timeButtons);
        StartBut.setStyle("-fx-background-color: transparent");
        StopBut.setStyle("-fx-background-color: transparent");
        ContinueBut.setStyle("-fx-background-color: transparent");
        AlClock.setStyle("-fx-background-color: transparent");
        Pomodoro.setStyle("-fx-background-color: transparent");
        SecRecorder.setStyle("-fx-background-color: transparent");
        Timer.setStyle("-fx-background-color: transparent");





        Scene scene = new Scene(group, 500,300);

        toggleGroup.selectToggle(autoTheme);
        stage.setResizable(false);

        stage.setTitle("Time cool app");//как назовём спектакль?)
        stage.setScene(scene); //The show must begin

        stage.show();//окрываем занавес
        //добавляем события на кнопки, зависящие напрямую от сцены (не могли создать раньше, т.к. сцены не было):
        Lightheme.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scene.setFill(Color.WHITE);

                StartBut.setTextFill(Color.BLACK);
                StopBut.setTextFill(Color.BLACK);
                ContinueBut.setTextFill(Color.BLACK);
                AlClock.setTextFill(Color.BLACK);
                Pomodoro.setTextFill(Color.BLACK);
                SecRecorder.setTextFill(Color.BLACK);
                Timer.setTextFill(Color.BLACK);
                ClockZone.setFill(Color.GAINSBORO);

            }
        });
        Darktheme.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scene.setFill(Color.DIMGREY);

                StartBut.setTextFill(Color.MISTYROSE);
                StopBut.setTextFill(Color.MISTYROSE);
                ContinueBut.setTextFill(Color.MISTYROSE);
                AlClock.setTextFill(Color.LIGHTGREY);
                Pomodoro.setTextFill(Color.LIGHTGREY);
                SecRecorder.setTextFill(Color.LIGHTGREY);
                Timer.setTextFill(Color.LIGHTGREY);
                ClockZone.setFill(Color.GREY);


            }
        });
       /* public boolean lightheme (boolean boo)
        {
            return ;
        }

        /*autoTheme.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
         */


    }
}
