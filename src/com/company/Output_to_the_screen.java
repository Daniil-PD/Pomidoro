package com.company;

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

                if (profile_now.equals(Main.get_now_profile())){
                    profile_now = Main.get_now_profile();
                    flag_changes = true;
                }

            }

            if (flag_changes){ // дописать вывод
                clearConsole();

                System.out.print("Таймер: " + remaining_time%60 + ":" + remaining_time/60 + "\r");


            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
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
