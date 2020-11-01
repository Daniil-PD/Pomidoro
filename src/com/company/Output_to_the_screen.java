package com.company;

import java.util.Scanner;

public class Output_to_the_screen extends Thread
{
    @Override
    public void run(){

        long remaining_time = 0;
        one_profile profile_now = Main.get_now_profile();

        boolean flag_changes = false;
        while (true) {

            if (!flag_changes){
                if (remaining_time != Main.get_remaining_time()){
                    remaining_time = Main.get_remaining_time();
                    flag_changes = true;
                }

                if (!profile_now.equals(Main.get_now_profile())){
                    profile_now = Main.get_now_profile();
                    flag_changes = true;
                }

            }

            if (flag_changes){ // дописать вывод
                clearConsole();
try{
                System.out.println("Таймер: " + remaining_time/60 + ":"+remaining_time%60);
                //System.out.println(profile_now.name_profile);
                // выводит профиль каждый раз

                    stop_processing();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                flag_changes = false;
            }


            /*
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */

        }
    }

    private void stop_processing() throws InterruptedException {
        boolean flag = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("stop");
        boolean s = scanner.hasNext();
        if(s) //https://stackoverflow.com/questions/2779484/why-must-wait-always-be-in-synchronized-block
            wait();
    }


    public static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }


}
