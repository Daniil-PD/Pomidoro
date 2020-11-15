/*
     *Таймер
     *
     *Конструктор:
     * -Mechanism_stopwatch()              : Инициализирует начальные значения.
     *
     * Своства:
     *
     * boolean flag_pause                  : Состояние таймера
     * long time_start                     : Время снятия таймера с паузы
     * long time_that_passed               : Пройденое время с работы таймера до паузы
     * long time_timer                     : Продолжительность работы таймера
     *
     * Методы:
     * -void run()                         : Цикл жизни(работы) таймера
     * -long get_remaining_time            : Возвращает продолжительность после запускатаймера работы таймера в милисекунд
     * -void start_mechanism()             : Запуск таймера
     * -void pause_mechanism()             : Ставит таймер на паузу
     * -void stop_mechanism()              : Останавливает/Сбрасывает таймер
     * -void plusTime_mechanism(long time) : Добление доплнительного времени работы
     * -String state_mechanism()           : Возвращает состояние таймера
 */

package com.company;

public class Mechanism_timer extends Thread
{
    long time_start;
    boolean flag_pause;
    long time_timer;
    long time_that_passed;

    public Mechanism_timer(long time) //Ининциализация
    {
        time_timer = time;
        flag_pause = true;
        time_that_passed = 0;
    }

    @Override
    public void run()
    {
        time_start = System.currentTimeMillis();
        while (true) // цикл жизни
        {
            if (get_remaining_time() <= 0) //Условине остановки таймера
            {
                stop_mechanism(time_timer);
                Main.timer_finish();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public long get_remaining_time() //оставшееся время работы таймера
    {
        if (flag_pause) return time_timer - time_that_passed; //при состояннии паузы
        else return time_timer - (System.currentTimeMillis() - time_start); // при состояннии работы
    }

    public void start_mechanism()
    {
        if (!flag_pause) return; // Проверка состояния
        time_start = System.currentTimeMillis(); // время отсчета
        time_start -= time_that_passed; // сдвиг из-за паузы
        flag_pause = false; //смена состояния
    }

    public void pause_mechanism()
    {
        if(flag_pause) return; // Проверка состояния
        time_that_passed = System.currentTimeMillis() - time_start;// Расчет пройденного времени до паузы
        flag_pause = true; //Смена состояния
    }

    public void stop_mechanism(long time)
    {
        if (!flag_pause) return; // Проверка состояния
        // Ининциализация
        time_timer = time;
        flag_pause = true;
        time_that_passed = 0;
    }

    public void plusTime_mechanism(long time) //Добление времени
    {
        if (flag_pause) return;
        time_start -= time; //сдвиг из-за доп времени
    }
    public String state_mechanism() // Возврат состояния таймера
    {
        if (flag_pause){
            return "pause";
        }
        return null;
    }


}
