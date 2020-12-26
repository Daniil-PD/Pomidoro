/*
 *Будильник
 *
 *Конструктор:
 * -Mechanism_stopwatch()                    : Инициализирует начальные значения.
 *
 * Своства:
 *
 * boolean time_alarm                        : Время срабатывания будильника от начала дня
 * long flag_power                           : Состояние будильника (сработает/не сработает)
 *
 * Методы:
 * -long get_local_time()                    : Возвращает при ВКЛ: время до звонка в милисекундах /// при ВЫКЛ: время будильника
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
    boolean isActive = true;

    void disable(){
        isActive=false;
    }

    private long get_remaining_time()
    {
        if (!flag_power) return time_alarm;
        else if (((System.currentTimeMillis()+4*60*60*1000)%(60*60*24*1000))>time_alarm) return time_alarm + 24*60*60*1000 - (System.currentTimeMillis()+4*60*60*1000)%(60*60*24*1000);
            else return time_alarm - (System.currentTimeMillis()+4*60*60*1000)%(60*60*24*1000);

        //Если будильник не должен сработать то вывести время
        //Иначе если сейчас 18:00 а звонок в 07:00, то ост время (07:00 + 24ч - 18:00) в милисекундах
        //Иначе если сейчас 07:00 а звонок в 18:00, то ост время (18:00 - 07:00) в милисекундах
        //System.currentTimeMillis возвращает время пройденное с 01.01.1970 00:00:00 в милисекундах по гринвичу
        // Прибавляем 4 часа из-за часового пояса (GMT+4),а потом выражаем текущее время (xx:xx:xx) в милисекундах
    }

    public Mechanism_alarmclock(long time) //Ининциализация
    {
        time_alarm = time;
        flag_power = true;
    }

    @Override
    public void run()
    {
        while (isActive) // цикл жизни
        {
            if ((get_remaining_time() < 10) && flag_power)
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

    public void setFlag_power(boolean flag_power) {
        this.flag_power = flag_power;
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
