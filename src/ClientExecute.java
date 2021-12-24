import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

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
    ClientConnection clientConnection = ClientConnection.getInstance();

    public static ClientExecute instance = new ClientExecute();     //only one instance in a program

    private ClientExecute() {
        //serverAddress = "localhost";     //Not Done: this address should be input by users
        ClientConnection.getInstance();
        //mainSocket = clientConnection.getMainSocket();
    }

    static ClientExecute getInstance() {
        return instance;
    }

    public void setMainSocket(Socket mainSocket) {
        this.mainSocket = mainSocket;
    }

    void loginMessageSend(String userName, String password) {       //send username and password to server
        try {
            System.out.println("server address:" + serverAddress);
            Socket loginSocket = new Socket(serverAddress, 10002);
            BufferedWriter loginWriter = new BufferedWriter(new OutputStreamWriter(loginSocket.getOutputStream()));
            loginWriter.write(userName + "\n");
            //loginWriter.newLine();
            loginWriter.write(password + "\n");
            //loginWriter.newLine();
            loginWriter.flush();
            loginWriter.close();
            loginSocket.close();
            System.out.println("login send done!");
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
            registerSocket.close();
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
            homepageReceiveSocket.close();
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
            moneyChangeDOS.flush();
            moneyChangeDOS.close();
            moneyChangeSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void transferAccountSend(String toId, Double amount) {      //send an id and a Double
        try {
            Socket transferSendSocket = new Socket(serverAddress, 10006);
//            DataOutputStream transferDOS = new DataOutputStream(transferSendSocket.getOutputStream());
            System.out.println("toID:" + toId + " Amount:" + amount);
            BufferedWriter transferBufferedWriter = new BufferedWriter(new OutputStreamWriter(transferSendSocket.getOutputStream()));
            transferBufferedWriter.write(toId + "\n");
            transferBufferedWriter.write(amount.toString() + "\n");
            transferBufferedWriter.flush();
            transferBufferedWriter.close();
            transferSendSocket.close();
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
            personListSocket.close();
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


    void exportPdfToLocation(String location) {
        if (location == null) {

        }

    }

    void exportXlsToLocation(ArrayList<FMPerson> personInXls) {
        //DataOutputStream dOS = new DataOutputStream()
        try {
            File file = new File("export.xls");
            if (file.exists()) {
                file.delete();  //make sure the old file is deleted
            }
            file.createNewFile();   //create a new file to write in
            WritableWorkbook workbook = Workbook.createWorkbook(new FileOutputStream(file));
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
            Label userName = new Label(0, 0, "username");
            sheet.addCell(userName);
            Label password = new Label(1, 0, "password");
            sheet.addCell(password);
            Label numberId = new Label(2, 0, "number id");
            sheet.addCell(numberId);
            Label phoneNumber = new Label(3, 0, "phone number");
            sheet.addCell(phoneNumber);
            Label gender = new Label(4, 0, "gender");
            sheet.addCell(gender);
            Label birthDate = new Label(5, 0, "birth date");
            sheet.addCell(birthDate);
            Label money = new Label(6, 0, "money");
            sheet.addCell(money);
            Label id = new Label(7, 0, "id");
            sheet.addCell(id);
            int total = personInXls.size();
            for (int i = 0; i < total; i++) {
                FMPerson tmp = personInXls.get(i);
                Label iUserName = new Label(0, i + 1, tmp.getUserName());
                sheet.addCell(iUserName);
                Label iPassword = new Label(1, i + 1, tmp.getPswd());
                sheet.addCell(iPassword);
                Label iNumberId = new Label(2, i + 1, tmp.getNumberId());
                sheet.addCell(iNumberId);
                Label iPhoneNumber = new Label(3, i + 1, tmp.getPhoneNumber());
                sheet.addCell(iPhoneNumber);
                Label iGender = new Label(4, i + 1, tmp.getGender());
                sheet.addCell(iGender);
                Label iBirthDate = new Label(5, i + 1, tmp.getBirthDate().toString());
                sheet.addCell(iBirthDate);
                Label iMoney = new Label(6, i + 1, Double.toString(tmp.getMoney()));
                sheet.addCell(iMoney);
                Label iId = new Label(7, i + 1, tmp.getId());
                sheet.addCell(iId);
            }
            workbook.write();
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ArrayList<FMPerson> importFromXls() {
        ArrayList<FMPerson> personList = new ArrayList<FMPerson>();
        try {
            File file = new File("export.xls");
            if (!file.exists()) {
                return personList;
            }
            FileInputStream fIS = new FileInputStream(file);
            jxl.Workbook wb = Workbook.getWorkbook(fIS);
            Sheet[] sheets = wb.getSheets();
            for (int i = 1; i < sheets.length; i++) {
                Sheet rs = wb.getSheet(i);
                FMPerson tmpPerson = new FMPerson();
                StringBuilder sB = new StringBuilder();
                String[] result = new String[10];
                for(int j = 0;j<8;j++){
                    Cell[] cells = rs.getRow(j);
                    for(int k = 0;k< cells.length;k++){
                        sB.append(cells[k].getContents());
                    }
                   result[j] = sB.toString();
                }
                tmpPerson.setUserName(result[0]);
                tmpPerson.setPswd(result[1]);
                tmpPerson.setNumberId(result[2]);
                tmpPerson.setPhoneNumber(result[3]);
                tmpPerson.setGender(result[4]);
                //tmpPerson.setBirthDate(result[5]); TODO:string to ???.date
                tmpPerson.setMoney(Double.parseDouble(result[6]));
                tmpPerson.setId(result[7]);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return personList;
        }

    }


    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }
}