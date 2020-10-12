

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        initCounter(); // тут метод остановки часов, т.е. значение кнопок
    }
    private void initCounter()
    {
        Stop.addActionListener(new ActionListener() // мозги кнопки Stop
                               {
                                   public void actionPerformed(ActionEvent e) {
                                       // сами мозги кнопки Остановить
                                   }
                               }
        );
        Resume.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // мозги кнопки Продолжить
            }
        });
    }
    private void updateTime()
    {
        // тут - настройка отображения текущего обновляемого времени
    }
}
    // описание метода остановки и продолжения таймера с внутренним анонимным классом
/*
{
    @Override
    public void run(){

    }

} */
//не забыть добавить в Main строки по окну при окончании написания скелета!