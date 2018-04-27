package classworks.serialization.socketapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    private int port;

    public SimpleServer(int port) {
        this.port = port;
    }

    private void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server on: " + serverSocket);

            while(true) {

                Socket sock = serverSocket.accept();
                try {
                    getMess(sock);
                }
                catch (ClassNotFoundException e) {
                    System.out.println("Wrong mess");
                    e.printStackTrace();
                }
                finally {
                    sock.close();
                }
            }

        }


    }

    private void getMess(Socket socket) throws IOException, ClassNotFoundException {
        String host = socket.getInetAddress().getHostAddress();

        try (ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());
             // ObjectOutputStream objOut = socket.getOutputStream();
            ) {
            Object obj = objIn.readObject();

            printMess((Message) obj, host);
        }

    }

    private void printMess(Message msg, String SenderAddr) {
        System.out.println("message: " + msg.getMessText() +
                            " from: " + msg.getSender() +
                            " " + SenderAddr
        );

    }

    public static void main(String[] args) throws IOException {
        if(args == null || args.length == 0) {
            throw new IllegalArgumentException("port must be specified");
        }

        int port = Integer.parseInt(args[0]);
        SimpleServer simpleServer = new SimpleServer(port);
        simpleServer.start();

    }
}
