package com.company;

import javax.xml.crypto.Data;
import java.sql.Date;

public class Mechanism_alarmclock extends Thread {

    long time_alarm;
    boolean flag_power;

    private long get_local_time()
    {
        return System.currentTimeMillis()%(60*60*24*1000)+4*60*60*1000;
    }

    public Mechanism_alarmclock(long time) //Ининциализация
    {
        time_alarm = time;
        flag_power = true;
    }

    @Override
    public void run()
    {
        while (true) // цикл жизни
        {
            if ((get_local_time() == time_alarm) && flag_power)
            {
                //оповещение
                flag_power = false;
                Main.alarmclock_finish();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void turn_on_off_mechanism(boolean flag)
    {
        flag_power = flag;
    }

    public void setTime_alarm(long time_alarm)
    {
        this.time_alarm = time_alarm;
    }

    public String state_mechanism()
    {
        if (flag_power)
        {
            return "turn_on";
        }
        return "turn_off";
    }
}
