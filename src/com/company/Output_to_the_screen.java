/*
 *Вывод на экран
 *Методы:
 * - void updat_timeText()                        : Переводит значения времени (из Main) в строку
 * - void ChoiceF(int choice)                     : Осуществляет смену кнопок под основные функции
 * - void start_output_to_the_screen(Stage stage) : Вывод основного GUI
 */
//  в мейне появились методы текущего профиля. Привязать к темам всех окон. Привязать окно установки времени профиля
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
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


import java.io.File;
public class Output_to_the_screen {

    private static int Selected = 1;

    public static Group groupOfFuncts;
    public static ToggleGroup toggleGr;
    public static Boolean theme;
    private static void updat_timeText() {
        switch (Selected) {
            case 1:
            {

                long time  = Main.pomidoro_get_remaining_time()/1000;

                long sek = time % 60;
                time /= 60;
                long min = time % 60;
                time/=60;
                long hour = time%60;
                timeText.setText( Long.toString(hour/ 10) + Long.toString(hour% 10) + ":" +
                        Long.toString(min/ 10) + Long.toString(min% 10) + ":" +
                                Long.toString(sek/ 10) + Long.toString(sek% 10));
                break;
            }

            case 2:
            {
                long time  = Main.timer_get_remaining_time()/1000;
                long sek = time % 60;
                time /= 60;
                long min = time % 60;
                time /= 60;
                timeText.setText(
                        Long.toString(min/ 10) + Long.toString(min% 10) + ":" +
                                Long.toString(sek/ 10) + Long.toString(sek% 10));
                break;
            }
            case 3:
            {
                long time  = Main.stopwatch_get_past_time();
                long mls = time %1000;
                time /= 1000;
                long sek = time % 60;
                time /= 60;
                long min = time % 60;
                time /= 60;
                long hour = time % 60;
                if (hour == 0)
                {
                    timeText.setText(
                            Long.toString(min/ 10) + Long.toString(min% 10) + ":" +
                                    Long.toString(sek/ 10) + Long.toString(sek% 10) + ":" +
                                    Long.toString(mls/ 100)+ Long.toString(mls / 10 % 10) + Long.toString(mls% 10));
                }
                else
                {
                    timeText.setText(
                            Long.toString(hour/ 10) + Long.toString(hour% 10) + ":" +
                                    Long.toString(min/ 10) + Long.toString(min% 10) + ":" +
                                    Long.toString(sek/ 10)+ Long.toString(sek % 10));
                }






                break;
            }

            case 4:
                timeText.setText(
                        Long.toString((Main.pomidoro_get_remaining_time() / (1000 * 3600)) % 60) + ":" +
                        Long.toString((Main.pomidoro_get_remaining_time() / (1000*60)) % 60) +":"+
                        Long.toString((Main.pomidoro_get_remaining_time() / 1000) % 60));

                break;


            //Long.toString((Main.pomidoro_get_remaining_time()) % 1000));
        }
    }

    private static final Text timeText = new Text(Long.toString((Main.pomidoro_get_remaining_time() % 1000 * 60 * 60 * 24) / 1000 * 60 * 60) + ":" +
            Long.toString((Main.pomidoro_get_remaining_time() % 1000 * 60 * 60) / 1000 * 60) + ":" +
            Long.toString((Main.pomidoro_get_remaining_time() % 1000 * 60) / 1000));


    public static void start_output_to_the_screen(Stage stage) throws Exception {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                                    public void handle(WindowEvent we) {
                                        Main.full_stop();
                                    }
                                });

        groupOfFuncts = new Group();
        Group groupOfAll = new Group(groupOfFuncts);
        Rectangle ClockZone = new Rectangle(350, 200); //поле заднего фона часов
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
                Media sound = new Media(new File("Another One Bites The Dust.mp3").toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                HelpWindow.newHelpWindow("Справка");
                mediaPlayer.stop();

            }
        });
        menuHelp.getItems().add(menuHelp1);


        MenuItem AddProfile1 = new MenuItem("Добавить профиль");
        AddProfile1.setOnAction(event -> AddProfile.AddProfileWindow("Добавление профиля"));
        MenuItem ChangeProfile = new MenuItem("Удалить/Сменить текущий профиль");
        ChangeProfile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ReviewProfile.RevProf("Сменить или удалить профиль");
            }
        });



        menuProfile.getItems().addAll(AddProfile1, ChangeProfile); // группируем профиль

        RadioMenuItem Lightheme = new RadioMenuItem("Светлая тема"); // список меню настройки
        RadioMenuItem Darktheme = new RadioMenuItem("Темная тема");
        toggleGr = new ToggleGroup(); // создаём группу выбора для тем (галочка д.б. только у 1-ой)
        Lightheme.setToggleGroup(toggleGr);
        Darktheme.setToggleGroup(toggleGr);
        toggleGr.selectToggle(Darktheme);
        menuSettings.getItems().addAll(Lightheme, Darktheme); // группируем настройки
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
        DropShadow shadowInButtn = new DropShadow();
        Pomodoro.setEffect(shadowInButtn);





        Pomodoro.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AlClock.setEffect(null);
                SecRecorder.setEffect(null);
                Timer.setEffect(null);
                Pomodoro.setEffect(shadowInButtn);

            }
        });

        Timer.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AlClock.setEffect(null);
                SecRecorder.setEffect(null);
                Pomodoro.setEffect(null);
                Timer.setEffect(shadowInButtn);
            }
        });
        SecRecorder.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AlClock.setEffect(null);
                SecRecorder.setEffect(shadowInButtn);
                Pomodoro.setEffect(null);
                Timer.setEffect(null);
            }
        });
        AlClock.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AlClock.setEffect(shadowInButtn);
                SecRecorder.setEffect(null);
                Pomodoro.setEffect(null);
                Timer.setEffect(null);
            }
        });
        Scene scene = new Scene(groupOfAll, 500, 300);

        scene.getStylesheets().add("file:DarkStyle.css");
        scene.setFill(Color.web("#200f33"));
        shadowInButtn.setColor(Color.GRAY);
        setts.selectToggle(Pomodoro);

        AlClock.setTextFill(Color.LIGHTGREY);
        Pomodoro.setTextFill(Color.LIGHTGREY);
        SecRecorder.setTextFill(Color.LIGHTGREY);
        Timer.setTextFill(Color.LIGHTGREY);
        AlClock.setStyle("-fx-background-color: #40334a");
        Pomodoro.setStyle("-fx-background-color: #40334a");
        SecRecorder.setStyle("-fx-background-color: #40334a");
        Timer.setStyle("-fx-background-color: #40334a");
        ClockZone.setFill(Color.web ("#362c40"));
        timeText.setFill(Color.web("#d1cbd6"));
        menuBar.setStyle("-fx-background-color: #50405e");
        theme=false;


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

        stage.setResizable(false);

        stage.setTitle("Time cool app");//как назовём спектакль?)
        stage.setScene(scene); //The show must begin
        stage.getIcons().add(new Image("file:64.png"));

        stage.show();
         Lightheme.setOnAction(new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent actionEvent) {
               scene.getStylesheets().clear();
               scene.setFill(Color.web("#f1f0f7"));
               scene.getStylesheets().add("file:LightStyle.css");
               shadowInButtn.setColor(Color.BLACK);
               setts.selectToggle(Pomodoro);


                AlClock.setTextFill(Color.web("#27203b"));
                Pomodoro.setTextFill(Color.web("#27203b"));
                SecRecorder.setTextFill(Color.web("#27203b"));
                Timer.setTextFill(Color.web("#27203b"));

               AlClock.setStyle("-fx-background-color: #c8cadb");
               Pomodoro.setStyle("-fx-background-color: #c8cadb");
               SecRecorder.setStyle("-fx-background-color: #c8cadb");
               Timer.setStyle("-fx-background-color: #c8cadb");
               timeText.setFill(Color.web("#27203b"));

               ClockZone.setFill(Color.WHITE);
               menuBar.setStyle("-fx-background-color: #e7e4f2");
               theme = true;

            }
        });
        Darktheme.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scene.getStylesheets().clear();
                scene.getStylesheets().add("file:DarkStyle.css");
                scene.setFill(Color.web("#200f33"));
                shadowInButtn.setColor(Color.GRAY);
                setts.selectToggle(Pomodoro);

                AlClock.setTextFill(Color.LIGHTGREY);
                Pomodoro.setTextFill(Color.LIGHTGREY);
                SecRecorder.setTextFill(Color.LIGHTGREY);
                Timer.setTextFill(Color.LIGHTGREY);
                AlClock.setStyle("-fx-background-color: #40334a");
                Pomodoro.setStyle("-fx-background-color: #40334a");
                SecRecorder.setStyle("-fx-background-color: #40334a");
                Timer.setStyle("-fx-background-color: #40334a");
                ClockZone.setFill(Color.web ("#362c40"));
                timeText.setFill(Color.web("#d1cbd6"));
                menuBar.setStyle("-fx-background-color: #50405e");
                theme=false;

            }
        });

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
                SetAlarmTimeWindow.SetTime();
                ChoiceF(4);
            }
        });

    }
    public static void ChoiceF(int choice) { //выбор пользователем одной из 4х функций (визуал)
        try {

            HBox timeButtFuncts = new HBox();
            Button StartBut = new Button("Старт");
            Button StopBut = new Button("Стоп");
            Button PauseBut = new Button("Пауза");
            StartBut.setStyle("-fx-background-color: transparent");
            StopBut.setStyle("-fx-background-color: transparent");
            PauseBut.setStyle("-fx-background-color: transparent");
            Selected = choice;

            switch (choice) {

                case 1:
                    StartBut.setOnAction(event -> Main.pomidor_start_mechanism());
                    StopBut.setOnAction(event -> Main.pomidor_stop_mechanism());
                    PauseBut.setOnAction(event -> Main.pomidor_pause_mechanism());
                    Button PlusFiveMinutes = new Button("+5 минут");
                    PlusFiveMinutes.setOnAction(event -> Main.pomidor_plusTime_mechanism(5*60*1000));
                    StartBut.setTextFill(Color.INDIANRED);
                    StopBut.setTextFill(Color.INDIANRED);
                    PauseBut.setTextFill(Color.INDIANRED);
                    PlusFiveMinutes.setTextFill(Color.INDIANRED);

                    timeButtFuncts.getChildren().addAll(StartBut, StopBut, PauseBut, PlusFiveMinutes);
                    timeButtFuncts.setSpacing(10);
                    timeButtFuncts.setLayoutX(175);
                    timeButtFuncts.setLayoutY(255);
                    groupOfFuncts.getChildren().add(timeButtFuncts);
                    PlusFiveMinutes.setStyle("-fx-background-color: transparent");

                    break;
                case 2:
                    StartBut.setOnAction(event -> Main.timer_start_mechanism()); // Сюда и ниже прописать нужную функцию
                    StopBut.setOnAction(event -> Main.timer_stop_mechanism(60));
                    PauseBut.setOnAction(event -> Main.timer_pause_mechanism());
                    Button Plus15sec = new Button("+15 сек.");
                    Plus15sec.setOnAction(event -> Main.timer_plusTime_mechanism(-15000));
                    Button Plus60sec = new Button("+60 сек.");
                    Plus60sec.setOnAction(event -> Main.timer_plusTime_mechanism(-60000));
                    Button Plus10min = new Button("+10 min.");
                    Plus10min.setOnAction(event -> Main.timer_plusTime_mechanism(-10*60000));
                    timeButtFuncts.getChildren().addAll(StartBut, StopBut, PauseBut, Plus15sec, Plus60sec, Plus10min);
                    timeButtFuncts.setSpacing(5);
                    timeButtFuncts.setLayoutX(130);
                    timeButtFuncts.setLayoutY(255);
                    groupOfFuncts.getChildren().add(timeButtFuncts);
                    Plus15sec.setStyle("-fx-background-color: transparent");
                    Plus60sec.setStyle("-fx-background-color: transparent");
                    Plus10min.setStyle("-fx-background-color: transparent");
                    StartBut.setTextFill(Color.INDIANRED);
                    StopBut.setTextFill(Color.INDIANRED);
                    PauseBut.setTextFill(Color.INDIANRED);
                    Plus15sec.setTextFill(Color.INDIANRED);
                    Plus60sec.setTextFill(Color.INDIANRED);
                    Plus10min.setTextFill(Color.INDIANRED);

                    break;
                case 3:
                    StartBut.setOnAction(event -> Main.stopwatch_start_mechanism());
                    StopBut.setOnAction(event -> Main.stopwatch_stop_mechanism());
                    PauseBut.setOnAction(event -> Main.stopwatch_pause_mechanism());
                    timeButtFuncts.getChildren().addAll(StartBut, StopBut, PauseBut);
                    timeButtFuncts.setSpacing(10);
                    timeButtFuncts.setLayoutX(220);
                    timeButtFuncts.setLayoutY(255);
                    timeText.setLayoutX(-10);
                    groupOfFuncts.getChildren().add(timeButtFuncts);
                    StartBut.setTextFill(Color.INDIANRED);
                    StopBut.setTextFill(Color.INDIANRED);
                    PauseBut.setTextFill(Color.INDIANRED);
                    break;
                case 4:

                    StartBut.setOnAction(event -> Main.pomidor_start_mechanism());
                    StopBut.setOnAction(event -> Main.pomidor_stop_mechanism());
                    timeButtFuncts.getChildren().addAll(StartBut, StopBut);
                    timeButtFuncts.setSpacing(10);
                    timeButtFuncts.setLayoutX(250);
                    timeButtFuncts.setLayoutY(255);
                    groupOfFuncts.getChildren().add(timeButtFuncts);
                    StartBut.setTextFill(Color.INDIANRED);
                    StopBut.setTextFill(Color.INDIANRED);

                    break;
            }
        } catch (Exception e) {

        }

    }
}

