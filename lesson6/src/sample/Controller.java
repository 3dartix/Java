package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    TextField textField;

    @FXML
    TextArea textArea;

    @FXML
    TextArea OnlineArea;

    @FXML
    TitledPane onlinePanel;

    Socket socket;
    DataInputStream in; //входящий поток
    DataOutputStream out; //исходящий поток

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    String name = "Вася";
    boolean closed = false;

    //отрабатывает при запуске
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket(IP_ADRESS,PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            //Новый поток
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        out.writeUTF(name + " вошел в чат");
                        //цикл для работы
                        while (!closed){
                            String str = in.readUTF();
                            //Date currentDate = new Date();
                            //SimpleDateFormat dateFormat = new SimpleDateFormat();
                            //textArea.appendText(name + ", " + dateFormat.format(currentDate) + "\n" + str + "\n");
                            textArea.appendText(str);
                        }
                        //System.out.println("выходим из цикла");

                    } catch (IOException e){
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }


                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage(){
        try {
            out.writeUTF(name + ": " + textField.getText());
            textField.clear();
            textField.requestFocus(); //оставить фокус
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        try {
            out.writeUTF(name + " вышел из чата" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        closed = true;
        Platform.exit();
    }
}
