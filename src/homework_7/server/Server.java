package homework_7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class Server {

    private static int PORT = 8189;
    ServerSocket server = null;
    Socket socket = null;
    List<server.ClientHandler> clients;
    private server.AuthService authService;

    public Server() {
        clients = new Vector<>();
        authService = new server.SimpleAuthService();

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new server.ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void broadCastMsg(server.ClientHandler sender, String msg) {
        String message = String.format("%s : %s", sender.getNickname(), msg);
        for (server.ClientHandler client : clients) {
            client.sendMsg(message + "\n");
        }
    }

    void sendMessage(server.ClientHandler sender, String toNickname, String msg) {
        String message = String.format("[Private] %s : %s", sender.getNickname(), msg);
        for (server.ClientHandler client : clients) {
            if (client.getNickname().equals(toNickname)) {
                client.sendMsg(message + "\n");
            }
            if (client.equals(sender)) {
                client.sendMsg(message + "\n");
            }
        }
    }

    public void subscribe(server.ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(server.ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public server.AuthService getAuthService(){
        return authService;
    }

}
