package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Settings {
    /**Менеджер профилей V0.2
     *
     *Конструкторы:
     * -User_profiles(): Папка для хранения данных распологается вместе с программой.
     * -User_profiles(String путь_до_файла): Папка для хранения данных распологается в деректории путь_до_файла.
     *
     * Методы:
     * -one_profile index (int index): возвращает профиль по индексом index (надо чекнуть что по памяти но мне лень).
     * -int size() возвращает количество профилей.
     * -boolean delite_index (int index) удаляет профиль под индексом index. В случае неудачи возвращает false (как и некоторые другие методы).
     * -boolean add_new_profile(one_profile профиль) принимает профиль который добавляет в конец списка.
     */
    private static int cout_profile = 0;
    private String path_to_profile = "";
    private ArrayList<one_profile> profiles = new ArrayList<>();
    private boolean theme = true;

    public Settings() {
        update_data();
    }

    public ArrayList<one_profile> ger_list(){
        return profiles;
    }

    public boolean get_theme(){
        return theme;
    }

    public void set_theme(boolean set){
        theme = set;
        full_rewrite_data();
    }

    public Settings(String path_to_profile) {
        this.path_to_profile = path_to_profile;
        update_data();
    }

    public one_profile index (int index){
        one_profile buff_profile = profiles.get(index);
        return new one_profile(buff_profile.name_profile, buff_profile.work_timer, buff_profile.rest_timer);

    }

    public int size() {
        return profiles.size();
    }

    public boolean delite_index (int index){
        try{
            profiles.remove(index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        try (FileWriter writer = new FileWriter(path_to_profile + "profiles.txt", false)) //открываем файл для записи
        { writer.write(""); //очишаем файл
            writer.flush();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            //return false;
        }

        try (FileWriter writer = new FileWriter(path_to_profile + "profiles.txt", true)) //открываем файл для записи
        {
            if (theme) {
                writer.write("theme: true\n\n");
            } else {
                writer.write("theme: false\n\n");
            }

            writer.flush();


        for (one_profile G : profiles) { //записываем каждый профиль


                String string_to_file = "name_profile: " + G.name_profile + "\n" +
                        "work_timer: " + G.work_timer + "\n" +
                        "rest_timer: " + G.rest_timer + "\n\n"; // формируем запись о новом профиле
                writer.write(string_to_file);
                writer.flush();


        }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
            return false;
        }
        boolean flag_to_qveri = false;
        for (int i = 0; i < 10; i++) {
            if (update_data()) {
                flag_to_qveri = true;
                break;
            }
        }
        full_rewrite_data();
        return flag_to_qveri;
    }

    boolean full_rewrite_data() {
        //update_data();

        try (FileWriter writer = new FileWriter(path_to_profile + "profiles.txt", false)) //открываем файл для записи
        {
            writer.write(""); //очишаем файл
            writer.flush();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            //return false;
        }

        try (FileWriter writer = new FileWriter(path_to_profile + "profiles.txt", true)) //открываем файл для записи
        {
            if (theme) {
                writer.write("theme: true \n\n");
            } else {
                writer.write("theme: false \n\n");
            }

            writer.flush();


            for (one_profile G : profiles) { //записываем каждый профиль


                String string_to_file = "name_profile: " + G.name_profile + "\n" +
                        "work_timer: " + G.work_timer + "\n" +
                        "rest_timer: " + G.rest_timer + "\n\n"; // формируем запись о новом профиле
                writer.write(string_to_file);
                writer.flush();


            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
            return false;
        }
        boolean flag_to_qveri = false;
        for (int i = 0; i < 10; i++) {
            if (update_data()) {
                flag_to_qveri = true;
                break;
            }
        }


        return true;
    }


    private boolean update_data () {
        String[] words;
        profiles.clear();
        one_profile buff_profile = new one_profile();
        buff_profile.clear();
        try(FileReader reader  = new FileReader(path_to_profile + "profiles.txt")) //открываем файл для записи
        {
            String line = "";
            Scanner scan = new Scanner(reader);

            if (scan.hasNextLine()){
                line = scan.nextLine();
                if (!line.isEmpty()){
                    words = line.split(" ");
                    if (words.length >= 2) {
                        if (words[0].equals("theme:")){
                            theme = words[1].equals("true");

                        }
                    }
                }
            }

            while (scan.hasNextLine()) {


                line = scan.nextLine();
                if (line.isEmpty()){ //если блок кончился
                    if (buff_profile.isFull()){
                        profiles.add(new one_profile(buff_profile.name_profile, buff_profile.work_timer, buff_profile.rest_timer));
                    }
                    // тут надо вставить буфер в список
                    buff_profile.clear();
                } else {
                    words = line.split(" ");
                    if (words.length >= 2) {
                        switch (words[0]){
                            case "name_profile:":
                                buff_profile.name_profile = words[1];
                                break;
                            case "work_timer:":
                                buff_profile.work_timer = Integer.parseInt(words[1]);
                                break;
                            case "rest_timer:":
                                buff_profile.rest_timer = Integer.parseInt(words[1]);
                                break;
                        }
                    }
                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

    public boolean add_new_profile(one_profile G){ // Добавить новый профиль
        String string_to_file = "name_profile: " + G.name_profile + "\n" +
                "work_timer: " + G.work_timer + "\n" +
                "rest_timer: " + G.rest_timer + "\n\n"; // формируем запись о новом профиле
        try(FileWriter writer = new FileWriter(path_to_profile + "profiles.txt", true)) //открываем файл для записи
        {
            writer.write(string_to_file); // записываем в конец
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            return false;
        }
        boolean flag_to_qveri = false; // усиленно обновляем инфу
        for (int i = 0; i<10 ; i++) {
            if (update_data()) {
                flag_to_qveri = true;
                break;}
        }



        return flag_to_qveri;
    }

}
