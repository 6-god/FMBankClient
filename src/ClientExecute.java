import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientExecute {
    private String serverAddress;
    private Socket mainSocket = null;
    ClientConnection clientConnection = null;

    public static ClientExecute instance= new ClientExecute();
    private ClientExecute(){
        serverAddress = "39.99.61.152";     //this address should be input by users
        clientConnection = new ClientConnection(serverAddress);
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
            Socket loginSocket = new Socket(serverAddress, 10002);
            BufferedWriter loginWriter = new BufferedWriter(new OutputStreamWriter(loginSocket.getOutputStream()));
            loginWriter.write(userName);
            loginWriter.write(password);
            loginWriter.flush();
            loginWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    void registerMassageSend(FMPerson personToBeRegistered){
        try{
            Socket registerSocket = new Socket(serverAddress,10003);
            DataOutputStream registerDOS = new DataOutputStream(registerSocket.getOutputStream());
            ObjectOutputStream registerOOS = new ObjectOutputStream(registerDOS);
            registerOOS.writeObject(personToBeRegistered);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}