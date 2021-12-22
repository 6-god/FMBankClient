import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientConnection {     //This class will connect the mainSocket
    private String serverIpAddress = "localhost";
    private Socket mainSocket;       //mainSocket is designed to transport the String message when you click button and jump to the next frame
    static BufferedWriter bufferedWriter = null;    //mainSocket's writer
    static BufferedReader bufferedReader = null;    //mainSocket's reader
    private static ClientConnection instance = new ClientConnection();

    public static ClientConnection getInstance() {
        return instance;
    }

    private ClientConnection() {
        initialize();
    }

    void initialize() {             //connect the main socket
        try {
            mainSocket = new Socket();
            System.out.println(serverIpAddress);
            InetAddress address = InetAddress.getByName(serverIpAddress);
            InetSocketAddress socketAddress = new InetSocketAddress(address, 10001);
            mainSocket.connect(socketAddress);
            bufferedReader = new BufferedReader(new InputStreamReader(mainSocket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(mainSocket.getOutputStream()));
            System.out.println("initialize connected!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    class ReceiveThread extends Thread {      //there is no need to use multi-thread
//        @Override
//        public void run() {
//
//        }
//    }

//    static class SendThread extends Thread {
//        @Override
//        public void run() {
//
//        }
//    }

    public static void Send(String messageToBeSend) {       //method to send mainSocket message
        try {
            bufferedWriter.write(messageToBeSend);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setServerIpAddress(String serverIpAddress) {
        this.serverIpAddress = serverIpAddress;
    }

    public Socket getMainSocket() {
        return mainSocket;
    }

    public static BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public static BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }
}