/*
 *Секундомер
 *
 *Конструктор:
 * -Mechanism_stopwatch()        : Инициализирует начальные значения.
 *
 * Своства:
 *
 * boolean flag_pause            : Состояние секундомера
 * static long time_start        : Время снятия секундомера с паузы
 * static long time_that_passed  : Пройденое время с работы секундомера до паузы
 *
 * Методы:
 * -long get_past_time           : Возвращает количество милисекунд прошедших после запуска секундомера
 * -void start_mechanism()       : Запуск секундамера
 * -void pause_mechanism()       : Ставит секундамер на паузу
 * -void stop_mechanism()        : Останавливает/Сбрасывает секундамер
 * -String state_mechanism()     : Возвращает состояние секундомера
 */

package com.company;

public class Mechanism_stopwatch
{
    boolean flag_pause;
    static long time_start;
    static long time_that_passed;
    boolean isActive = true;

    void disable(){
        isActive=false;
    }

    public Mechanism_stopwatch() // Ининциализация
    {
        flag_pause = true;
        time_that_passed = 0;
    }

    public long get_past_time() // Время работы секундамера
    {
        if (flag_pause) return time_that_passed; // при состояннии паузы
        else return  System.currentTimeMillis() - time_start; // при состояннии работы
    }

    public void start_mechanism() //Запуск
    {
        if (!flag_pause) return; // проверка состояния
        time_start = System.currentTimeMillis(); // время отсчета
        time_start -= time_that_passed; // сдвиг из-за паузы
        flag_pause = false; //смена состояния
    }

    public void pause_mechanism() //Пауза
    {
        if(flag_pause) return; // Проверка состояния
        time_that_passed = System.currentTimeMillis() - time_start; // Расчет пройденного времени до паузы
        flag_pause = true; //Смена состояния
    }

    public void stop_mechanism()
    {
        if (!flag_pause) return; // Проверка состояния
        // Ининциализация
        flag_pause = true;
        time_that_passed = 0;
    }

    public String state_mechanism() // Возврат состояния секундомера
    {
        if (flag_pause)
        {
            return "pause";
        } //и так далее
        return null;
    }
}