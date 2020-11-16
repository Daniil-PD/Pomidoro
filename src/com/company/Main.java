package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    static one_profile now_profile_pomidoro;
    static boolean debag_mode = false;


    public static void main(String[] args) {

        //----------------------загрузка переменных--------------------

        debag_mode = java.util.Arrays.asList(args).contains("-L");



        if (debag_mode) System.out.println("Start");

        if (debag_mode) System.out.println("Инициализация классов..");
        User_profiles profiles = new User_profiles();
        Output_to_the_screen screen = new Output_to_the_screen();
        Mechanism_pomidoro Mpomidoro = new Mechanism_pomidoro();
        Mechanism_timer Mtimer = new Mechanism_timer();
        Mechanism_alarmclock Malarmclock = new Mechanism_alarmclock();
        Mechanism_stopwatch Mstopwatch = new Mechanism_stopwatch();


        if (debag_mode) System.out.println("Подготовка к старту");

        now_profile_pomidoro = profiles.index(0); // Не правильно

        //----------------------загрузка переменных--------------------


        if (debag_mode) System.out.println("Старт классов");
        Mpomidoro.stop_mechanism(now_profile_pomidoro.work_timer,now_profile_pomidoro.rest_timer); //
        Mpomidoro.start();//запускаем поток


        screen.start();


        
        while (true)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

	// ЗАГРУЗКА ОКНА
       Interactive_menu app = new  Interactive_menu();
        app.setVisible(true);// отображение окна - да
        app.pack(); //установить оптимальный размер окна


    }

    public static one_profile get_now_profile(){
        return now_profile_pomidoro;
    }

    public static long get_remaining_time(){

        return Mechanism_pomidoro.get_remaining_time();

        //return (1800000 - System.currentTimeMillis() % 1800000 ) / 1000;
    }

    public static void pomidor_finish(){


    }




}



//        Пример добавления профиля
//        int[] arr = new int[3];
//        arr[0] = 31;
//        arr[1] = 255;
//        arr[2] = 10;
//        one_profile profile = new one_profile("profile8",arr,25,10);


//        one_profile profile;
//        for (int i = 0 ; i < profiles.size(); i++){
//
//            profile = profiles.index(i);
//            System.out.println(profile);
//        }
//        profile = null;
