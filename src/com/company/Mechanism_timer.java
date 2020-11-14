package com.company;

public class Mechanism_timer extends Thread
{
    long time_start;
    boolean flag_pause;
    long work_timer;
    long time_timer;
    long time_that_passed;

    public Mechanism_timer()
    {
        flag_pause = true;
        time_that_passed = 0;
    }

    @Override
    public void run()
    {
        //предлагаю его включить до инициализации
        // таймера и профиля или перенести сист время

        time_start = System.currentTimeMillis();
        while (true)
        {
            if (get_remaining_time() <= 0)
            {
                stop_mechanism();
                Main.timer_finish();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setTime_timer(long time_timer)
    {
        this.time_timer = time_timer;
    }

    public long get_remaining_time()
    {
        if (flag_pause) return time_timer - time_that_passed;
        else return time_timer - (System.currentTimeMillis() - time_start);
    }

    public void start_mechanism()
    {
        if (!flag_pause) return;
        time_start = System.currentTimeMillis();
        time_start -= time_that_passed;
        flag_pause = false;
    }

    public void pause_mechanism()
    {
        if(flag_pause) return;
        time_that_passed = System.currentTimeMillis() - time_start;
        flag_pause = true;
    }

    public void stop_mechanism()
    {
        if (!flag_pause) return;
        flag_pause = true;
        time_that_passed = 0;
    }

    public void plusTime_mechanism(long time)
    {
        if (flag_pause) return;
        time_start -= time;
    }
    public String state_mechanism(){
        if (flag_pause){
            return "pause";
        }


        return null;
    }


}
