package com.company;

public class Mechanism_stopwatch
{
    boolean flag_pause;
    static long time_start;
    static long time_that_passed;
     
    public Mechanism_stopwatch()
    {
        flag_pause = true;
        time_that_passed = 0;
    }

    public long get_past_time()
    {
        if (flag_pause) return time_that_passed;
        return  System.currentTimeMillis() - time_start;
    }

    public void start_mechanism()
    {
        time_start = System.currentTimeMillis();
        if (flag_pause) time_start -= time_that_passed;
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

    public String state_mechanism(){
        if (flag_pause)
        {
            return "pause";
        } //и так далее
        return null;
    }
}
