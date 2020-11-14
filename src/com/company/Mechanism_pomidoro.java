package com.company;


public class Mechanism_pomidoro extends Thread {

    static long time_start;
    static boolean flag_pause = true;
    static long work_timer = 10000;
    static long rest_timer = 1000;
    static boolean time_work_or_rest = true;
    static long time_that_passed; //прошедшее время
    static boolean stop = false;

    @Override
    public void run(){ //предлагаю его включить до инициализации
        // таймера и профиля или перенести сист время
        time_start = System.currentTimeMillis();
        while (true)
        {
            //тут код по проверке окончания времени
            if(pause_mechanism()) stop = true; //если сработал, то остановился
            else if(start_mechanism()) stop = true; //не проходил через старт после паузы, значит остановился

            //else другие условия

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static long get_remaining_time(){ //как параметр основного таймера
        if (flag_pause) {
            if (time_work_or_rest) return (time_start-System.currentTimeMillis()%time_start)/rest_timer;
            else return (//хз);
        }
        else {
            if (time_work_or_rest) return 3;
            else return 4;
        }
        }
        //return (1800000 - System.currentTimeMillis() % 1800000 ) / 1000;


    public boolean stop_mechanism(long work_timer, long rest_timer){
        Mechanism_pomidoro.work_timer = work_timer;
        Mechanism_pomidoro.rest_timer = rest_timer;
        time_start = System.currentTimeMillis();

        pause_mechanism();


        return true;
    }
    public boolean start_mechanism(){
        if (flag_pause){
            time_start = time_that_passed + System.currentTimeMillis();
            flag_pause = false;
        }

        return false;
    }
    public boolean pause_mechanism(){

        if(!flag_pause) {
            time_that_passed =  System.currentTimeMillis()-time_start ;
            flag_pause = true;
        }


        return true;
    }
    public boolean plusTime_mechanism(long time){
        if (!flag_pause)
        {
            time_start += time;
        } else
            time_start += time + time_that_passed; //???

        return true;
    }
    public String state_mechanism(){
        if (flag_pause){
            return "pause";
        }


        return null;
    }






}

