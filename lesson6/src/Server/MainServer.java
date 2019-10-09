package Server;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
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

            while (true) {
                socket = server.accept(); //при подключени нового клиента
                System.out.println("Клиент подключился");
                //создаем новый сокет
                clients.add(new ClientHandler(this, socket)); //и добавляем в коллекцию
            }


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

    public void DeleteClientFromCollection(ClientHandler cli){
        System.out.println(clients.size() + " Delete");
        //Iterator i = clients.iterator();

        for (ClientHandler client: clients) {
            if(client.equals(cli)){
                clients.remove(client);
                break;
            }
        }
//        while (i.hasNext()) {
//            System.out.println(" Delete 2");
//            i.next();
//            if (i.equals(cli)) {
//                i.remove();
//                System.out.println("\nThe element Orange is removed");
//                break;
//            }
//        }

        System.out.println(clients.size() + " Delete");
    }
}
