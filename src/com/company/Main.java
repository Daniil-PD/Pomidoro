package com.company;


import javax.swing.plaf.TableHeaderUI;

public class Main {

    static one_profile now_profile;
    static boolean debag_mode = false;


    public static void main(String[] args) {

        //----------------------загрузка переменных--------------------

        debag_mode = java.util.Arrays.asList(args).contains("-L");



        if (debag_mode) System.out.println("Start");

        if (debag_mode) System.out.println("Инициализация классов..");
        User_profiles profiles = new User_profiles();
        Output_to_the_screen screen = new Output_to_the_screen();
        Clock_mechanism mechanism = new Clock_mechanism();


        if (debag_mode) System.out.println("Подготовка к старту");

        now_profile = profiles.index(0); // Не правильно

        //----------------------загрузка переменных--------------------


        if (debag_mode) System.out.println("Старт классов");
        mechanism.start();
        screen.start();
        
        while (true)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

	// write your code here
    }

    public static one_profile get_now_profile(){
        return now_profile;
    }

    public static long get_remaining_time(){

        return Clock_mechanism.remaining_time();

        //return (1800000 - System.currentTimeMillis() % 1800000 ) / 1000;
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
