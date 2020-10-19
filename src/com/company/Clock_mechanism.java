package com.company;

public class Clock_mechanism extends Thread
{
   static long time_start;
    @Override
    public void run(){

        time_start = System.currentTimeMillis();

        while (true){
            //проверять на законченость таймера

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



    public static long remaining_time(){
        int x = Main.get_now_profile().work_timer;
        //return (1800000 - System.currentTimeMillis() % 1800000 ) / 1000;
        return (x -(System.currentTimeMillis() - time_start)/ 1000 ) ;
    }
}
