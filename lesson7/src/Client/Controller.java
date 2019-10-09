package Client;

import Server.AuthService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.Socket;


public class Controller {

    private boolean isAuthorized;

    @FXML
    TextField textField;
    @FXML
    TextArea textArea;
    @FXML
    TextArea OnlineArea;
    @FXML
    TitledPane onlinePanel;
    @FXML
    VBox authorizationPanel;
    @FXML
    HBox chatPanel;
    @FXML
    TextField loginField;
    @FXML
    TextField passwordField;
    @FXML
    Label labelAuth;

    Socket socket;
    DataInputStream in; //входящий поток
    DataOutputStream out; //исходящий поток

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;



    private void setAuthrized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
        if (!isAuthorized) {
            authorizationPanel.setVisible(true);
            authorizationPanel.setManaged(true);
            chatPanel.setVisible(false);
            chatPanel.setManaged(false);
        } else {
            authorizationPanel.setVisible(false);
            authorizationPanel.setManaged(false);
            chatPanel.setVisible(true);
            chatPanel.setManaged(true);
        }
    }

    public void Connect() {
        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/authok")) {
                                setAuthrized(true);
                                break;
                            } else {
                                //labelAuth.setLabelFor(str);
                                textArea.appendText(str);
                            }
                        }

                        while (true) {
                            String str = in.readUTF();
                            if (str.equalsIgnoreCase("/clientClose")) {
                                break;
                            }

                            textArea.appendText(str + "");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        setAuthrized(false);
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage(){
        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Dispose() {
        System.out.println("Отправляем сообщение на сервер о завершении работы");
        try {
            if (out != null) {
                out.writeUTF("/end");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryToAuth(ActionEvent actionEvent) {
        if (socket == null || socket.isClosed()) {
            Connect();
        }

        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passwordField.getText());
            //out.writeUTF("/auth " + "login1" + " " + "pass1");
            loginField.clear();
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
