package com.company;


import java.util.Arrays;

public class one_profile {
    //Просто контенер для хранения
    String name_profile; // имя профиля
    int[] color_profile = new int[3]; // цвет
    int work_timer; //рабочий таймер сек
    int rest_timer; //таймер отдыха сек
    one_profile(){
        clear();
    }

    one_profile (String name_profile,final int[] color_profile,int work_timer,int rest_timer){
        this.name_profile = name_profile;
        System.arraycopy(color_profile, 0, this.color_profile, 0, 3);
        this.work_timer = work_timer;
        this.rest_timer = rest_timer;
    }

    public void clear() { //очищает все поля
        this.name_profile  = null;
        this.color_profile[0] = -1;
        this.color_profile[1] = -1;
        this.color_profile[2] = -1;
        this.work_timer = 0;
        this.rest_timer = 0;
    }

    public boolean isFull() { //все поля профиля заполнены
        return this.name_profile  != null &&
        this.color_profile[0] != -1 &&
        this.color_profile[1] != -1 &&
        this.color_profile[2] != -1 &&
        this.work_timer != 0 &&
        this.rest_timer != 0;
    }
    @Override
    public String toString() { //Простой вывод
        return "name_profile: " + this.name_profile + "\n" +
                "color_profile: " + this.color_profile[0] + " " + this.color_profile[1] + " " + this.color_profile[2] + " " + "\n" +
                "work_timer: " + this.work_timer + "\n" +
                "rest_timer: " + this.rest_timer + "\n\n"; // формируем запись о профиле
    }

    @Override
    public boolean equals(Object o) {
        // 1
        if (this == o) {
            return true;
        }

        // 2
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // 3
        one_profile simpson = (one_profile) o;
        return rest_timer == simpson.rest_timer &&
                work_timer == simpson.work_timer &&
                name_profile.equals(simpson.name_profile) &&
                Arrays.equals(color_profile, simpson.color_profile);
    }



}
