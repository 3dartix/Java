package Lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowChat extends JFrame {
    public MyWindowChat() {
        setTitle("Chat");
        setBounds(800,300,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        centerPanel.setBackground(Color.gray);
        bottomPanel.setBackground(Color.pink);

        bottomPanel.setPreferredSize(new Dimension(1,40));

        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());

        JButton jtb = new JButton("Send");

        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        centerPanel.add(jsp, BorderLayout.CENTER);
        JTextField jtf = new JTextField();

        bottomPanel.add(jtf);
        bottomPanel.add(jtb);

        jtf.setPreferredSize(new Dimension(300,28));
        jta.setEditable(false);

        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
                jtf.grabFocus();
            }
        });

       // jtb.addKeyListener();

        setVisible(true);
    }
}


class MainChatWindow {
    public static void main(String[] args) {
     new MyWindowChat();
    }
}