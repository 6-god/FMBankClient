import javax.crypto.spec.PSource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientExecute {        //create individual sockets to send different information
    private String serverAddress;
    private Socket mainSocket = null;
    ClientConnection clientConnection = null;

    public static ClientExecute instance = new ClientExecute();     //only one instance in a program

    private ClientExecute() {
        //serverAddress = "localhost";     //Not Done: this address should be input by users
        ClientConnection.getInstance();
        mainSocket = clientConnection.getMainSocket();
    }

    static ClientExecute getInstance() {
        return instance;
    }

    public void setMainSocket(Socket mainSocket) {
        this.mainSocket = mainSocket;
    }

    void loginMessageSend(String userName, String password) {       //send username and password to server
        try {
            Socket loginSocket = new Socket(serverAddress, 10002);
            BufferedWriter loginWriter = new BufferedWriter(new OutputStreamWriter(loginSocket.getOutputStream()));
            loginWriter.write(userName);
            loginWriter.write(password);
            loginWriter.flush();
            loginWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void registerMassageSend(FMPerson personToBeRegistered) {       //send a person's instance to server
        try {
            Socket registerSocket = new Socket(serverAddress, 10003);
            DataOutputStream registerDOS = new DataOutputStream(registerSocket.getOutputStream());
            ObjectOutputStream registerOOS = new ObjectOutputStream(registerDOS);
            registerOOS.writeObject(personToBeRegistered);
            registerOOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    FMPerson personalHomePageReceive() {        //receive a person's instance from server
        try {
            Socket homepageReceiveSocket = new Socket(serverAddress, 10004);
            DataInputStream homePageDIS = new DataInputStream(homepageReceiveSocket.getInputStream());
            ObjectInputStream homePageOIS = new ObjectInputStream(homePageDIS);
            FMPerson homepagePerson = (FMPerson) homePageOIS.readObject();
            return homepagePerson;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    void changeMoneySend(Double changeAmount) {     //send a Double to server
        try {
            Socket moneyChangeSocket = new Socket(serverAddress, 10005);
            DataOutputStream moneyChangeDOS = new DataOutputStream(moneyChangeSocket.getOutputStream());
            moneyChangeDOS.writeDouble(changeAmount);
            moneyChangeDOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void transferAccountSend(String toId, Double amount) {      //send an id and a Double
        try {
            Socket transferSendSocket = new Socket(serverAddress, 10006);
//            DataOutputStream transferDOS = new DataOutputStream(transferSendSocket.getOutputStream());
            BufferedWriter transferBufferedWriter = new BufferedWriter(new OutputStreamWriter(transferSendSocket.getOutputStream()));
            transferBufferedWriter.write(toId);
            transferBufferedWriter.write(amount.toString());
            transferBufferedWriter.flush();
            transferBufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void changePersonalInformation() {      //send a String(button that user choose) firstly, then a String or a Date Object
        String chooseMode = null;
        try {
            Socket changeInformationSocket = new Socket(serverAddress, 10007);
            BufferedWriter changeInformationBufferedWriter = new BufferedWriter(new OutputStreamWriter(changeInformationSocket.getOutputStream()));
            while (chooseMode == null) {
                //chooseMode = getMethod in GUI
                //sleep for a while if can
            }

            changeInformationBufferedWriter.write(chooseMode);

            if (!chooseMode.equals("birth_date")) {
                //get and send a String
            } else {
                //send the Date
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void sendPersonToBeImported(ArrayList<FMPerson> personList) {   //send an ArrayList
        try {
            Socket personListSocket = new Socket(serverAddress, 10008);
            DataOutputStream personListDOS = new DataOutputStream(personListSocket.getOutputStream());
            ObjectOutputStream personListOOS = new ObjectOutputStream(personListDOS);
            personListOOS.writeObject(personList);
            personListOOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<FMPerson> receivePerson() {       //receive ArrayList<FMPerson>
        try {
            Socket receivePersonSocket = new Socket(serverAddress, 10009);
            DataInputStream personDIS = new DataInputStream(receivePersonSocket.getInputStream());
            ObjectInputStream personOIS = new ObjectInputStream(personDIS);
            return (ArrayList<FMPerson>) personOIS.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }

    ArrayList<Double> receivePdfReport() {  //receive Arraylist<Double>
        try {
            Socket pdfSocket = new Socket(serverAddress, 10010);
            ObjectInputStream pdfOIS = new ObjectInputStream(new DataInputStream(pdfSocket.getInputStream()));
            return (ArrayList<Double>) pdfOIS.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



    void exportPdfToLocation(String location){
        if(location == null){

        }

    }

    void exportXlsToLocation(String location, ArrayList<FMPerson> personInXls){

    }


}