

package com.company;
import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Int_Menu_Thread extends Thread
{

}
public class Interactive_menu extends JFrame // оконный вывод информации - расположение кнопок, вывод таймера
{
    private int HR, MN, SEC; // переменные для получения времени из updateTime()
    boolean flag=true;
    private JLabel countTime;// Содержание вывода времени
    private JButton Stop; //переменные для кнопок
    private JButton Resume;
    public Interactive_menu() {

        super("Pomodoro");
        while (flag) {
            HR = updateTime() / 3600;
            MN = (updateTime() - HR * 3600) / 60;
            SEC = updateTime() - HR * 3600 - MN * 60;
            countTime = new JLabel(HR + ":" + MN + ":" + SEC);// подумать как можно сделать рамку часов, изменить ее цвет+увеличить цифры
            Stop = new JButton("Stop");
            Resume = new JButton("Resume");
            JPanel buttonsPanel = new JPanel(new FlowLayout());// объект панельки кнопок
            add(countTime, BorderLayout.CENTER); // добавление расположения таймера
            buttonsPanel.add(Stop);
            buttonsPanel.add(Resume);
            //больше кнопок
            add(buttonsPanel, BorderLayout.SOUTH); // добавление панели кнопок вниз посередине
            initCounter(); // тут метод остановки часов, т.е. значение кнопок
        }
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
    private int updateTime()
    {
       int hr, mins, sec, commonTime;
        Calendar timeOut = Calendar.getInstance();//создать календарь текущего вывода времени
        hr = timeOut.get(Calendar.HOUR);
        mins = timeOut.get(Calendar.MINUTE);
        sec = timeOut.get(Calendar.SECOND);
        commonTime=sec+mins*60+hr*3600;
        return commonTime;
    }
}
    // описание метода остановки и продолжения таймера с внутренним анонимным классом
/*
    @Override
    public void run(){

    }

*/
//не забыть добавить в Main строки по окну при окончании написания скелета!