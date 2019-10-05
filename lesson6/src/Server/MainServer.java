package Server;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class MainServer {
    private Vector<ClientHandler> clients;

    public MainServer() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            socket = server.accept(); //при подключени нового клиента
            System.out.println("Клиент подключился");
            //создаем новый сокет
            clients.add(new ClientHandler(this,socket)); //и добавляем в коллекцию


            //Scanner in = new Scanner(socket.getInputStream());
            //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //DataInputStream in = new DataInputStream(socket.getInputStream()); //входящий поток
            //DataOutputStream out = new DataOutputStream(socket.getOutputStream()); //исходящий поток

            //String str = in.readUTF();
            //out.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void BroadcastMessage(String msg){
        for (ClientHandler client: clients) {
            client.SendMessage(msg);
        }
    }
}
