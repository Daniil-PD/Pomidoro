

package com.company;

import javax.swing.*;
import java.awt.*;

class Int_Menu_Thread extends Thread
{

}
public class Interactive_menu extends JFrame // оконный вывод информации - расположение кнопок, вывод таймера
{
    private int time; //подумать как вывести с класса Clock_Mechanism тип вывода времени!!! (после того, как Вова собственно напишет)
    private JLabel countTime;// Содержание вывода времени
    private JButton Stop; //переменные для кнопок
    private JButton Resume;

    public Interactive_menu() {
        super("Pomodoro");
        countTime = new JLabel("Time" + time);// подумать как можно сделать рамку часов, изменить ее цвет+увеличить цифры
        Stop = new JButton("Stop");
        Resume = new JButton("Resume");
        JPanel buttonsPanel = new JPanel(new FlowLayout());// объект панельки кнопок
        add(countTime, BorderLayout.CENTER); // добавление расположения таймера
        buttonsPanel.add(Stop);
        buttonsPanel.add(Resume);
        add(buttonsPanel, BorderLayout.SOUTH); // добавление панели кнопок вниз посередине
        // ТУТ ДОЛЖНЫ ИСПОЛЬЗОВАТЬСЯ МЕТОДЫ таймера
    }
    // описание метода остановки и продолжения таймера с внутренним анонимным классом
{
    @Override
    public void run(){

    }
    
}
//не забыть добавить в Main строки по окну при окончании написания скелета!