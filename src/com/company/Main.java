package com.company;



public class Main {

    public static void main(String[] args) {

        //----------------------загрузка переменных--------------------

        final boolean debag_mode = java.util.Arrays.asList(args).contains("-L");



        if (debag_mode) System.out.println("Start");

        if (debag_mode) System.out.println("Инициализация классов..");
        User_profiles profiles = new User_profiles();
        Output_to_the_screen screen = new Output_to_the_screen();
        Clock_mechanism mechanism = new Clock_mechanism();


        if (debag_mode) System.out.println("Подготовка к старту");

        if(debag_mode) {}

        one_profile now_profile = profiles.index(0);


        if (debag_mode) System.out.println("Старт классов");
        mechanism.start();
        screen.start();


        //----------------------загрузка переменных--------------------



        int[] arr = new int[3];
        arr[0] = 31;
        arr[1] = 255;
        arr[2] = 10;
        one_profile profile = new one_profile("profile8",arr,25,10);

        profiles.add_new_profile(profile);

        for (int i = 0; i < profiles.size(); i++){
            profile = profiles.index(i);
            System.out.println(profile);
        }


        System.out.println();





	// write your code here
    }
}
