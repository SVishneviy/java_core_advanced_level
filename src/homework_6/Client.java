package homework_6;

import java.io.*;
import java.net.Socket;

public class Client {
    protected final String IP_ADDRESS = "localhost";
    protected final int PORT = 34855;
    protected Socket socket;
    protected BufferedReader bufferedReader;
    protected DataInputStream dataInputStream;
    protected DataOutputStream dataOutputStream;

    public static void main(String[] args) throws IOException {
        new Client();
    }

    public Client() throws IOException {
        socket = new Socket(IP_ADDRESS, PORT);
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
                while (!socket.isOutputShutdown()) {
                    dataOutputStream.writeUTF(bufferedReader.readLine());
                    dataOutputStream.flush();
                    if (bufferedReader.readLine().equals("exit")) {
                        break;
                    }
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
                while (!socket.isOutputShutdown()) {
                    String string = dataInputStream.readUTF();
                    System.out.println("Сервер: " + string);
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
