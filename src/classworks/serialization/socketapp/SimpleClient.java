package classworks.serialization.socketapp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class SimpleClient {

    private SocketAddress socketAddress;

    private Scanner scanner;

    public SimpleClient(SocketAddress address, Scanner scanner) {
        this.socketAddress = address;
        this.scanner = scanner;
    }

    public static void main(String[] args) throws IOException {
        String addr = null;

        if(args != null && args.length > 0) {
            addr = args[0];
        }

        Scanner scanner = new Scanner(System.in);

        if(addr == null) {
            System.out.println("Enter server address");
            addr = scanner.nextLine();
        }

        SimpleClient simpleClient = new SimpleClient(
                    parseAddr(addr), scanner
        );

        simpleClient.start();
    }

    private void start() throws IOException {
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        while (true) {
            System.out.println("Enter your message");
            String msg = scanner.nextLine();

            buildAndSendMess(name, msg);

        }
    }

    private void buildAndSendMess(String name, String msg) throws IOException {
        Message message = new Message(name, msg);
        sendMess(message);
    }

    private void sendMess(Message message) throws IOException {
        try (Socket socket = new Socket()) {
            socket.connect(socketAddress);

            try(OutputStream out = socket.getOutputStream()) {
                ObjectOutputStream objOut = new ObjectOutputStream(out);

                objOut.writeObject(message);
                objOut.flush();
            }
        }
    }

    private static SocketAddress parseAddr(String addr) {
        String[] str = addr.split(":");
        return new InetSocketAddress(str[0], Integer.parseInt(str[1]));
    }
}
