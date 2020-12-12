package com.company;


import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    static one_profile now_profile_pomidoro;
    static boolean debag_mode = false;
    static Mechanism_pomidoro Mpomidoro = new Mechanism_pomidoro();
    static Mechanism_timer Mtimer = new Mechanism_timer(1000*60*10);
    static Mechanism_alarmclock Malarmclock = new Mechanism_alarmclock(18*50*216000*1000);
    static Mechanism_stopwatch Mstopwatch = new Mechanism_stopwatch();


    public static void main(String[] args) {

        //----------------------загрузка переменных--------------------

        debag_mode = java.util.Arrays.asList(args).contains("-L");



        if (debag_mode) System.out.println("Start");

        if (debag_mode) System.out.println("Инициализация классов..");
        User_profiles profiles = new User_profiles();
        Output_to_the_screen screen = new Output_to_the_screen();
        Mpomidoro.stop_mechanism(1000*60*40,1000*60*10);
        //Mpomidoro.start_mechanism();
        //Mechanism_timer Mtimer = new Mechanism_timer(1000*60*10);
        //Mechanism_alarmclock Malarmclock = new Mechanism_alarmclock(18*50*216000*1000);
        //Mechanism_stopwatch Mstopwatch = new Mechanism_stopwatch();


        if (debag_mode) System.out.println("Подготовка к старту");

        now_profile_pomidoro = profiles.index(0); // Не правильно

        //----------------------загрузка переменных--------------------


        if (debag_mode) System.out.println("Старт классов");
        //Mpomidoro.stop_mechanism(now_profile_pomidoro.work_timer,now_profile_pomidoro.rest_timer); //
        Mpomidoro.start();//запускаем поток


        Application.launch(args); // запуск графики



//        while (true)
//        {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//        }

        // write your code here
    }

    public static one_profile get_now_profile(){
        return now_profile_pomidoro;
    }

    public static long pomidoro_get_remaining_time(){return Mpomidoro.get_remaining_time();}

    public static void pomidor_finish(){

    }

    public static void timer_finish(){


    }

    public static void alarmclock_finish(){
    }

    public static void pomidor_stop_mechanism(){Mpomidoro.stop_mechanism(1000*60*40,1000*60*10);}
    public static void pomidor_pause_mechanism(){Mpomidoro.pause_mechanism();}
    public static void pomidor_start_mechanism(){
        Mpomidoro.start_mechanism();
    }

    public static void timer_state_mechanism(){Mtimer.state_mechanism();}
    public static void timer_start_mechanism(){Mtimer.start_mechanism();}
    public static void timer_pause_mechanism(){Mtimer.pause_mechanism();}
    public static void timer_stop_mechanism(long time){Mtimer.stop_mechanism(time);}
    public static void timer_plusTime_mechanism(long time){Mtimer.plusTime_mechanism(time);}
    public static long timer_get_remaining_time(){return Mtimer.get_remaining_time();}

    public static void stopwatch_start_mechanism (){Mstopwatch.start_mechanism();}
    public static void stopwatch_pause_mechanism (){Mstopwatch.pause_mechanism();}
    public static void stopwatch_stop_mechanism (){Mstopwatch.stop_mechanism();}
    public static long stopwatch_get_past_time (){return Mstopwatch.get_past_time();}









    @Override
    public void start(Stage stage) throws Exception {
        Output_to_the_screen.start_output_to_the_screen(stage);
    }

    public static void full_stop() {
        Mpomidoro.disable();
        Mtimer.disable();
        Malarmclock.disable();
        Mstopwatch.disable();
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