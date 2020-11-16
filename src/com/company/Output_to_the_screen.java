package com.company;
/*
/*import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

*/





public class Output_to_the_screen extends Thread
{
    @Override
    public void run(){

        long remaining_time = 0;
        one_profile profile_now = Main.get_now_profile();

        boolean flag_changes = false;
        while (true    ) {

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

                System.out.println("Таймер: " + remaining_time/60 + ":"+remaining_time%60);


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
