package com.company;


import java.util.Date;
import java.util.Scanner;


public class Clock_mechanism extends Thread
{static int a;
   static long time_start;
    @Override

    public void run(){ //предлагаю его включить до инициализации
                        // таймера и профиля или перенести сист время
        time_start = System.currentTimeMillis();
        Date date = new Date();
        System.out.println(date.toString());

        switch_case();

    }

    public static void switch_case(){
        int operator;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите помодоро(1) или 2 ");
        operator = scanner.nextInt();

        switch(operator){
            case 1: pomodoro();

            break;
        }



    }
    public static int pomodoro(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите 30(1), 45(2), 60(3) min of pomodoro");
        /*
        * сделать здесь перегрузку методов, может есть библ с временем обратного отсчета?
        * */
        int operator_pom = scanner.nextInt();
        switch(operator_pom){
            case 1: remaining_time();// int x = Main.get_now_profile().work_timer;
                long remaining_time;
                remaining_time = Main.get_remaining_time();
                while(true ) {
                    System.out.println("Таймер: " + remaining_time / 60 + ":" + remaining_time % 60);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // a = (int) (x -(System.currentTimeMillis() - time_start)/ 1000);


            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }

        return 0;
    }


    public static long remaining_time(){
        int x = Main.get_now_profile().work_timer;
        //return (1800000 - System.currentTimeMillis() % 1800000 ) / 1000;
        return (x -(System.currentTimeMillis() - time_start)/ 1000 ) ;
    }
}
