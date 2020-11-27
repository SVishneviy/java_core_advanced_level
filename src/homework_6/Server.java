package homework_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    protected final int PORT = 34855;
    protected Socket socket;
    protected BufferedReader bufferedReader;
    protected DataInputStream dataInputStream;
    protected DataOutputStream dataOutputStream;

    public static void main(String[] args) throws IOException {
        new Server();
    }

    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Сервер запущен.");
        socket = serverSocket.accept();
        System.out.println("Клиент подключился.");
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        sendMessage().setDaemon(true);
        sendMessage().start();
        getMessage().start();
    }

    private Thread sendMessage() {
        return new Thread(() -> {
            try {
                while (!socket.isClosed()) {
                    dataOutputStream.writeUTF(bufferedReader.readLine());
                    dataOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private Thread getMessage() {
        return new Thread(() -> {
            try {
                while (!socket.isClosed()) {
                    String string = dataInputStream.readUTF();
                    if (string.equals("exit")) {
                        dataOutputStream.writeUTF("Клиент покинул сессию.");
                        dataOutputStream.flush();
                        System.out.println("Клиент отключился.");
                        break;
                    }
                    System.out.println("Клиент: " + string);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void disconnect() throws IOException {
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
    }

}
