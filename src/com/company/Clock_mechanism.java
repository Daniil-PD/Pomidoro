package com.company;


import java.util.Date;
import java.util.Scanner;


public class Clock_mechanism extends Thread{
static int a;
   static long time_start;
   static boolean flag = false;
    @Override

    public void run(){ //предлагаю его включить до инициализации
                        // таймера и профиля или перенести сист время
        time_start = System.currentTimeMillis();
        Date date = new Date();
        System.out.println(date.toString());



    }


    public static long remaining_time(){
        int x = Main.get_now_profile().work_timer;
        int systime = (int) System.currentTimeMillis();
        //return (1800000 - System.currentTimeMillis() % 1800000 ) / 1000;
        return (x -(System.currentTimeMillis() - time_start)/ 1000 ) ;
    }

    public static class Pomodoro extends Thread{//*
        /*
        * Заглушка на помодоро
        */
        public static long get_remaining_time(){ //как параметр основного таймера

            return Clock_mechanism.remaining_time();

            //return (1800000 - System.currentTimeMillis() % 1800000 ) / 1000;
        }

        public int Stop(/* передать параметры основного таймера*/){
            get_remaining_time(); //передача параметра

            return 0;
        }
        public int Start(){

            return 0;
        }
        public int Pause(){

            return 0;
        }
        public int PlusTime(/* передать параметры основного таймера*/){

            return 0;
        }
        public String State(/* передать параметры основного таймера*/){


            return null;
        }
        public void run(){
            //что будем здесь делать

        }
        public static void main(String args[]){
            (new Pomodoro()).start(); //запускает поток

        }
    }
    public  class Taimer extends Thread{
        /*
         * Заглушка на timer
         */
    }
    public  class StopWatch extends Thread{
        /*
         * Заглушка на секундомер
         */
    }
    public  class AlarmClock extends Thread{
        /*
         * Заглушка на будильник
         */
    }

}
//добавить функц вывода времени
