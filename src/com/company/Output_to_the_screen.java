package com.company;
import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.event.MouseEvent;
import java.io.File;

public class Output_to_the_screen {
    public static Group groupOfFuncts;
    private static void updat_timeText() {
        timeText.setText(
                Long.toString((Main.pomidoro_get_remaining_time() / (1000 * 60)) % 60) + ":" +
                        Long.toString((Main.pomidoro_get_remaining_time() / 1000) % 60));
        //Long.toString((Main.pomidoro_get_remaining_time()) % 1000));
    }

    private static final Text timeText = new Text(Long.toString((Main.pomidoro_get_remaining_time() % 1000 * 60 * 60 * 24) / 1000 * 60 * 60) + ":" +
            Long.toString((Main.pomidoro_get_remaining_time() % 1000 * 60 * 60) / 1000 * 60) + ":" +
            Long.toString((Main.pomidoro_get_remaining_time() % 1000 * 60) / 1000));

    public static void ChoiceF(int choice) { //выбор пользователем одной из 4х функций (визуал)
        try {

            HBox timeButtFuncts = new HBox();
            Button StartBut = new Button("Старт");
            Button StopBut = new Button("Стоп");
            Button PauseBut = new Button("Пауза");
            StartBut.setStyle("-fx-background-color: transparent");
            StopBut.setStyle("-fx-background-color: transparent");
            PauseBut.setStyle("-fx-background-color: transparent");

             switch (choice) {

                case 1:
                    StartBut.setOnAction(event -> Main.pomidor_start_mechanism());
                    StopBut.setOnAction(event -> Main.pomidor_stop_mechanism());
                    PauseBut.setOnAction(event -> Main.pomidor_pause_mechanism());
                    Button PlusFiveMinutes = new Button("+5 минут");
                    timeButtFuncts.getChildren().addAll(StartBut, StopBut, PauseBut, PlusFiveMinutes);
                    timeButtFuncts.setSpacing(10);
                    timeButtFuncts.setLayoutX(190);
                    timeButtFuncts.setLayoutY(255);
                    groupOfFuncts.getChildren().add(timeButtFuncts);
                    PlusFiveMinutes.setStyle("-fx-background-color: transparent");
                case 2:
                    StartBut.setOnAction(event -> Main.pomidor_start_mechanism()); // Сюда и ниже прописать нужную функцию
                    StopBut.setOnAction(event -> Main.pomidor_stop_mechanism());
                    PauseBut.setOnAction(event -> Main.pomidor_pause_mechanism());
                    Button Plus15sec = new Button("+15 сек.");
                    Button Plus60sec = new Button("+60 сек.");
                    Button Plus10min = new Button("+10 min.");
                    timeButtFuncts.getChildren().addAll(StartBut, StopBut, PauseBut, Plus15sec, Plus60sec, Plus10min);
                    timeButtFuncts.setSpacing(5);
                    timeButtFuncts.setLayoutX(130);
                    timeButtFuncts.setLayoutY(255);
                    groupOfFuncts.getChildren().add(timeButtFuncts);
                    Plus15sec.setStyle("-fx-background-color: transparent");
                    Plus60sec.setStyle("-fx-background-color: transparent");
                    Plus10min.setStyle("-fx-background-color: transparent");
                case 3:
                    StartBut.setOnAction(event -> Main.pomidor_start_mechanism());
                    StopBut.setOnAction(event -> Main.pomidor_stop_mechanism());
                    PauseBut.setOnAction(event -> Main.pomidor_pause_mechanism());
                    timeButtFuncts.getChildren().addAll(StartBut, StopBut, PauseBut);
                    timeButtFuncts.setSpacing(10);
                    timeButtFuncts.setLayoutX(220);
                    timeButtFuncts.setLayoutY(255);
                    groupOfFuncts.getChildren().add(timeButtFuncts);
                case 4:

                    StartBut.setOnAction(event -> Main.pomidor_start_mechanism());
                    StopBut.setOnAction(event -> Main.pomidor_stop_mechanism());
                    timeButtFuncts.getChildren().addAll(StartBut, StopBut);
                    timeButtFuncts.setSpacing(10);
                    timeButtFuncts.setLayoutX(250);
                    timeButtFuncts.setLayoutY(255);
                    groupOfFuncts.getChildren().add(timeButtFuncts);
            }
        } catch (Exception e) {

        }

    }
    public static void start_output_to_the_screen(Stage stage) throws Exception {
        groupOfFuncts = new Group();
        Group groupOfAll = new Group(groupOfFuncts);
        Rectangle ClockZone = new Rectangle(330, 200, Color.GAINSBORO); //поле заднего фона часов
        ClockZone.setX(140);
        ClockZone.setY(40);
        ClockZone.setArcHeight(105);
        ClockZone.setArcWidth(60);
        ChoiceF(1);
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
        MenuItem ChangeProfile = new MenuItem("Сменить текущий профиль");
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
        groupOfAll.getChildren().add(menuBar);


        // добавляем меню к актёрам
        VBox Settings = new VBox();
        ToggleButton Pomodoro = new ToggleButton("Помодоро");
        ToggleButton Timer = new ToggleButton("Таймер");
        ToggleButton SecRecorder = new ToggleButton("Секундомер");
        ToggleButton AlClock = new ToggleButton("Будильник");

        ToggleGroup setts = new ToggleGroup();
        Pomodoro.setToggleGroup(setts);
        Timer.setToggleGroup(setts);
        SecRecorder.setToggleGroup(setts);
        AlClock.setToggleGroup(setts);
        setts.selectToggle(Pomodoro);






        Timer.setMaxWidth(100);
        Pomodoro.setMaxWidth(100);
        SecRecorder.setMaxWidth(100);
        AlClock.setMaxWidth(100);
        Settings.getChildren().addAll(Pomodoro, Timer, SecRecorder, AlClock);
        Settings.setPadding(new Insets(30));
        Settings.setSpacing(30);
        Settings.setLayoutY(15);
        Settings.setAlignment(Pos.CENTER);
        groupOfAll.getChildren().add(ClockZone);
        groupOfAll.getChildren().add(Settings);


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        updat_timeText();
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        thread.setDaemon(true);
        thread.start();
        timeText.setX(160);
        timeText.setY(160);
        timeText.setFont(new Font(80));
        groupOfAll.getChildren().add(timeText);


        /*AlClock.setStyle("-fx-background-color: WHITESMOKE");
        Pomodoro.setStyle("-fx-background-color: WHITESMOKE");
        SecRecorder.setStyle("-fx-background-color: WHITESMOKE");
        Timer.setStyle("-fx-background-color: WHITESMOKE"); */


        Scene scene = new Scene(groupOfAll, 500, 300);

        toggleGroup.selectToggle(autoTheme);
        stage.setResizable(false);

        stage.setTitle("Time cool app");//как назовём спектакль?)
        stage.setScene(scene); //The show must begin
        stage.getIcons().add(new Image("file:64.png"));

        stage.show();//окрываем занавес
        //ПОКА ТЕМЫ НЕ РАБОТАЮТ!
       /*  Lightheme.setOnAction(new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent actionEvent) {
                scene.setFill(Color.WHITE);

                StartBut.setTextFill(Color.BLACK);
                StopBut.setTextFill(Color.BLACK);
                PauseBut.setTextFill(Color.BLACK);
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
                PauseBut.setTextFill(Color.MISTYROSE);
                AlClock.setTextFill(Color.LIGHTGREY);
                Pomodoro.setTextFill(Color.LIGHTGREY);
                SecRecorder.setTextFill(Color.LIGHTGREY);
                Timer.setTextFill(Color.LIGHTGREY);
                ClockZone.setFill(Color.GREY);


            }
        });
*/
        Pomodoro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                groupOfFuncts.getChildren().clear();
                ChoiceF(1);
            }
        });

        Timer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                groupOfFuncts.getChildren().clear();
                ChoiceF(2);
            }
        });

        SecRecorder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                groupOfFuncts.getChildren().clear();
                ChoiceF(3);
            }
        });
        AlClock.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                groupOfFuncts.getChildren().clear();
                ChoiceF(4);
            }
        });

    }
}
