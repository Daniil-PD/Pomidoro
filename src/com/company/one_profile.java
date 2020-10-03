package com.company;


public class one_profile {
    //Просто контенер для хранения
    String name_profile; // имя профиля
    int[] color_profile = new int[3]; // цвет
    int work_timers; //рабочий таймер
    int rest_timer; //таймер отдыха
    one_profile(){
        clear();
    }

    one_profile (String name_profile,final int[] color_profile,int work_timers,int rest_timer){
        this.name_profile = name_profile;
        System.arraycopy(color_profile, 0, this.color_profile, 0, 3);
        this.work_timers = work_timers;
        this.rest_timer = rest_timer;
    }

    public void clear() { //очищает все поля
        this.name_profile  = null;
        this.color_profile[0] = -1;
        this.color_profile[1] = -1;
        this.color_profile[2] = -1;
        this.work_timers = 0;
        this.rest_timer = 0;
    }

    public boolean isFull() { //все поля профиля заполнены
        return this.name_profile  != null &&
        this.color_profile[0] != -1 &&
        this.color_profile[1] != -1 &&
        this.color_profile[2] != -1 &&
        this.work_timers != 0 &&
        this.rest_timer != 0;
    }
    @Override
    public String toString() { //Простой вывод
        return "name_profile: " + this.name_profile + "\n" +
                "color_profile: " + this.color_profile[0] + " " + this.color_profile[1] + " " + this.color_profile[2] + " " + "\n" +
                "work_timers: " + this.work_timers + "\n" +
                "rest_timer: " + this.rest_timer + "\n\n"; // формируем запись о профиле
    }




}
