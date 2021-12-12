import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientExecute {
    private String serverAddress;
    private Socket mainSocket = null;
    ClientConnection clientConnection = null;

    public static ClientExecute instance= new ClientExecute();
    private ClientExecute(){
        clientConnection = new ClientConnection("39.99.61.152");
        mainSocket = clientConnection.getMainSocket();
    }
    static ClientExecute getInstance(){
        return instance;
    }

    public void setMainSocket(Socket mainSocket) {
        this.mainSocket = mainSocket;
    }

    void loginMessageSend(String userName,String password){
        try{

            ServerSocket loginSocket = new ServerSocket(10002);
            Socket socket = loginSocket.accept();
        }catch (IOException e){

        }

    }

}