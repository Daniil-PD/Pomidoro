package com.company;


public class Mechanism_pomidoro extends Thread {

    long time_start;
    boolean flag_pause = true;
    long work_timer = 1000*60*40;
    long rest_timer = 1000*60*10;
    boolean time_work_or_rest = false;
    long time_that_passed = 0; //прошедшее время
    boolean isActive = true;

    void disable(){
        isActive=false;
    }

    @Override
    public void run(){ //предлагаю его включить до инициализации
        // таймера и профиля или перенести сист время
        time_start = System.currentTimeMillis();
        while (isActive)
        {
            //тут код по проверке окончания времени


            //else другие условия

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long get_remaining_time(){ //как параметр основного таймера
        if (flag_pause) {
            if (time_work_or_rest) return rest_timer - time_that_passed;
            else return work_timer - time_that_passed;
        }
        else {

            if (time_work_or_rest) return rest_timer - (System.currentTimeMillis() - time_start);
            else return work_timer - (System.currentTimeMillis() - time_start);
        }
    }
    //return (1800000 - System.currentTimeMillis() % 1800000 ) / 1000;


    public boolean stop_mechanism(long work_timer, long rest_timer){
        this.work_timer = work_timer;
        this.rest_timer = rest_timer;
        if (flag_pause){
            if (time_work_or_rest){
                time_that_passed = 0;
            } else {
                time_that_passed = 0;
            }
        }else {

            time_start = System.currentTimeMillis();
        }
        pause_mechanism();


        return true;
    }
    public boolean start_mechanism(){
        if (flag_pause){
            time_start =  System.currentTimeMillis() - time_that_passed;
            flag_pause = false;
        }

        return false;
    }
    public boolean pause_mechanism(){

        if(!flag_pause) {
           time_that_passed =  System.currentTimeMillis()-time_start;
            flag_pause = true;
        }


        return true;
    }
    public boolean plusTime_mechanism(long time){
        if (!flag_pause)
        {
            time_start += time;
        } else
            time_that_passed -= time; //???

        return true;
    }
    public String state_mechanism(){
        if (flag_pause){
            return "pause";
        }


        return null;
    }






}

