package Server;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class MainServer {
    private Vector<ClientHandler> clients;

    public MainServer() throws SQLException {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        Scanner console = new Scanner(System.in);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String str = console.nextLine();
                    BroadcastMessage("Server: "+ str);
                }
            }
        }).start();

        try {
            AuthService.Connect();

//            String res = AuthService.getNickByLoginAndPass("login1", "pass2");
//            System.out.println(res);

            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился!");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        AuthService.Disconnect();
    }

    public void BroadcastMessage(String msg){
        for (ClientHandler client: clients) {
            client.SendMessage(msg);
        }
    }

    public void SendMessageToUser(String name, String msg){
        for (ClientHandler client: clients) {
            if(name.equalsIgnoreCase(client.nick)){
                client.SendMessage(msg);
            }
        }
    }

    public String GetAllOnlineUsers(){
        String users = "/usersOnline";
        for (ClientHandler client: clients) {
            users += client.nick + " ";
        }
        System.out.println(users);
        return users;
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public boolean isNickOnline (String nick) {
        boolean result = false;
        for (ClientHandler client: clients) {
            System.out.println(client.nick + "   " + nick);
            if (nick.equalsIgnoreCase(client.nick)){
                result = true;
                break;
            }
        }
        return result;
    }

}
