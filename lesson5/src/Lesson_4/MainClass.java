package Lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass {
    public static void main(String[] args) {
        new MyWindow();
    }
}

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("MyWindow");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton btn1 = new JButton("Ok");
        JButton btn2 = new JButton("Cancel");
        JButton btn3 = new JButton("btn3");

        JPanel jPanel = new JPanel(new GridLayout(1,2));

        // btn1.setPreferredSize(new Dimension(200,300));

        jPanel.add(btn1);
        jPanel.add(btn2);
        jPanel.add(btn3);

        add(jPanel, BorderLayout.SOUTH);

        int a = 10;

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ok");
            }
        });


//        setLayout(null);
//
//        btn1.setBounds(40,40,50,50);
//        btn2.setBounds(80,140,150,50);
//
//        add(btn1);
//        add(btn2);

        //add(btn1, BorderLayout.SOUTH);

        setBounds(800,300,400,400);
        setVisible(true);
    }
}
