package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in; //входящий поток
    private DataOutputStream out; //исходящий поток
    private MainServer server;
    private ClientHandler client;

    //private

    public ClientHandler(MainServer server, Socket socket) {
        try {
            client = this;
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            //пишем в консоль сервера
            Scanner scanner = new Scanner(System.in);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String msg = scanner.nextLine();
                        server.BroadcastMessage("Server: " + msg);
                    }
                }
            }).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        //общение
                        while (true){
                            String msg = in.readUTF();
                            System.out.println(msg);
                            server.BroadcastMessage(msg);
                        }
                    } catch (EOFException e){
                        System.out.println("Вася отвалился, закрываем сокет");
                    } catch (IOException e){
                        System.out.println("Другие ошибки");
                        e.printStackTrace();
                    }  finally {
                        //закрываем потоки
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //закрываем сокет
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.DeleteClientFromCollection(client);
                    }
                }
            }).start();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void SendMessage (String msg){
        try{
            out.writeUTF(msg + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
