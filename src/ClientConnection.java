import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientConnection {
    private String serverIpAddress;
    private Socket mainSocket = null;
    static BufferedWriter bufferedWriter = null;
    static BufferedReader bufferedReader = null;

    ClientConnection() {
        initialize();
    }

    ClientConnection(String ipAddress) {
        serverIpAddress = ipAddress;
        initialize();
    }

    void initialize() {             //connect the main socket
        while (!mainSocket.isConnected()) {
            try {
                InetAddress address = InetAddress.getByName(serverIpAddress);
                InetSocketAddress socketAddress = new InetSocketAddress(address, 10001);
                mainSocket.connect(socketAddress);
                bufferedReader = new BufferedReader(new InputStreamReader(mainSocket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(mainSocket.getOutputStream()));
                System.out.println("connected!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

//    class ReceiveThread extends Thread {
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

    public static void Send(String messageToBeSend){
        try{
            bufferedWriter.write(messageToBeSend);
            bufferedWriter.flush();
        }catch (IOException e){
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