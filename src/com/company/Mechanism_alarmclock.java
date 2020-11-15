/*
 *Будильник
     *
     *Конструктор:
     * -Mechanism_stopwatch()                    : Инициализирует начальные значения.
     *
     * Своства:
     *
     * boolean time_alarm                        : Время срабатывания будильника
     * long flag_power                           : Состояние будильника (сработает/не сработает)
     *
     * Методы:
     * -long get_local_time()                    : Возвращает текущее время в милисекундах (14:30->52 200 000)
     * -void run()                               : Цикл жизни(работы) будильника
     * -void turn_on_off_mechanism(boolean flag) : Задаем значение переменной flag_power
     * -setTime_alarm(long time_alarm)           : Задаем значение переменной time_alarm
     * -String state_mechanism()                 : Возвращает состояние будильника
 */

package com.company;

import javax.xml.crypto.Data;

public class Mechanism_alarmclock extends Thread {

    long time_alarm;
    boolean flag_power;

    private long get_local_time()
    {
        //System.currentTimeMillis возвращает время пройденное с 01.01.1970 00:00:00 в милисекундах по гринвичу
        // Прибавляем 4 часа из-за часового пояса (GMT+4),а потом выражаем текущее время (xx:xx:xx) в милисекундах
        return (System.currentTimeMillis()+4*60*60*1000)%(60*60*24*1000);
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
