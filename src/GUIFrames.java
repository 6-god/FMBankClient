//把监听器提取出来调用

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUIFrames {
    private Socket mainSocket = ClientConnection.getInstance().getMainSocket();

    private GUIFrames() {

    }

    static GUIFrames instance = new GUIFrames();

    public static GUIFrames getInstance() {
        return instance;
    }

    void initialize() {
        ClientConnection.getInstance();
        StartFrame.getInstance();
    }

    public Socket getMainSocket() {
        return mainSocket;
    }

    public boolean mainIsConnected() {
        //GUIFrames.getInstance().setMainSocket(ClientConnection.getInstance().getMainSocket());
        if (ClientConnection.getInstance().getMainSocket() == null) return false;
        System.out.println("main not null");
        return ClientConnection.getInstance().getMainSocket().isConnected();
    }
    //public static void main(String[] args) {
    //new RegisterFrame();
    //new RegisterResult();
    //new LogicResult();
    //new LoginFrame();
    //new HomePage();
    //new ChangeMoney();
    //new TransferAccount();
    //new ChangeResult();
    //new TransferResult();
    //new ChangeInformationSelection();
    //new ChangeInformation();
    //new ChangeInformationResult();
    //new ROOTAccount();
    //}


    public void setMainSocket(Socket mainSocket) {
        this.mainSocket = mainSocket;
    }
}


class StartFrame extends JFrame {
    public static StartFrame instance = new StartFrame();
    JFrame jf;

    private StartFrame() {
        jf = new JFrame("StartFrame");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel title = new JLabel("Fei Ma Bank");
        Font font = new Font("Times New Roman", Font.PLAIN, 50);
        title.setFont(font);
        Button button1 = new Button("Register");
        button1.setSize(100, 5);
        Button button2 = new Button("Login");
        button2.setSize(100, 5);
        Button button3 = new Button("Administrator");
        button3.setSize(100, 5);
        Button button4 = new Button("Change IP");
        button3.setSize(100, 5);
        //因为addActionListener需要一个ActionListener，所以就要new一个出来
        SFActionListener01 sfActionListener01 = new SFActionListener01();
        button1.addActionListener(sfActionListener01);
        // 创建一个垂直盒子容器, 把上面 6 个 JPanel 串起来作为内容面板添加到窗口
        SFActionListener02 sfActionListener02 = new SFActionListener02();
        button2.addActionListener(sfActionListener02);
        SFActionListener03 sfActionListener03 = new SFActionListener03();
        button3.addActionListener(sfActionListener03);
        SFActionListener04 sfActionListener04 = new SFActionListener04();
        button4.addActionListener(sfActionListener04);
        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(title);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(button1);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(button2);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(button3);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(button4);
        vBox.add(Box.createVerticalStrut(40));
        Box baseBox = Box.createHorizontalBox();
        baseBox.add(Box.createHorizontalStrut(30));
        baseBox.add(vBox);
        baseBox.add(Box.createHorizontalStrut(30));

        jf.setContentPane(baseBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setSize(150, 300);
        jf.setBounds(400, 300, 500, 500);
        jf.setVisible(true);
        windowClose(jf);

    }

    static StartFrame getInstance() {
        return instance;
    }


    JFrame getThisFrame() {
        return jf;
    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class SFActionListener01 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("register");
        RegisterFrame.getInstance().getJf().setVisible(true);
        StartFrame.getInstance().getThisFrame().dispose();
    }
}

class SFActionListener02 implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Login frame");
        LoginFrame.getInstance().getJf().setVisible(true);
        StartFrame.getInstance().getThisFrame().dispose();


    }
}

class SFActionListener03 implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("root");
        ROOTAccount.getInstance().getJf().setVisible(true);
        StartFrame.getInstance().getThisFrame().dispose();


    }
}

class SFActionListener04 implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("change ip");
        StartFrame.getInstance().getThisFrame().dispose();
        NoConnectionFrame.getInstance().getJf().setVisible(true);


    }
}

class RegisterFrame extends JFrame {
    private static RegisterFrame instance = new RegisterFrame();
    JFrame jf;
    JTextField text1 = new JTextField(10);
    JPasswordField text2 = new JPasswordField(10);
    JTextField text3 = new JTextField(10);
    JTextField text4 = new JTextField(10);
    JTextField text5 = new JTextField(10);
    JTextField text6 = new JTextField(10);

    private RegisterFrame() {
        jf = new JFrame("Users Login:");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        panel01.add(new JLabel("User Name:"));
        JLabel label01 = new JLabel();
        label01.setText("");
        label01.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel01.add(text1);
        panel01.add(label01);
        // 第 2 个 JPanel, 使用默认的浮动布局
        JPanel panel02 = new JPanel();
        panel02.add(new JLabel("Password:"));
        panel02.add(text2);
        JLabel label02 = new JLabel();
        label02.setText("");
        label02.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel02.add(label02);

        JPanel panel03 = new JPanel();
        panel03.add(new JLabel("Student Number:"));
        panel03.add(text3);
        JLabel label03 = new JLabel();
        label03.setText("");
        label03.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel03.add(label03);

        JPanel panel04 = new JPanel();
        panel04.add(new JLabel("Phone Number:"));
        panel04.add(text4);
        JLabel label04 = new JLabel();
        label04.setText("");
        label04.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel04.add(label04);

        JPanel panel05 = new JPanel();
        panel05.add(new JLabel("Gender:"));
        panel05.add(text5);
        JLabel label05 = new JLabel();
        label05.setText("");
        label05.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel05.add(label05);

        JPanel panel06 = new JPanel();
        panel06.add(new JLabel("Birthday:"));
        text6.setText("YYYY-MM-DD");
        panel06.add(text6);
        JLabel label06 = new JLabel();
        label06.setText("");
        label06.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel06.add(label06);

        Button button1 = new Button("REGISTER");
        Button button2 = new Button("RETURN");
        //因为addActionListener需要一个ActionListener，所以就要new一个出来
        RFActionListener01 rfActionListener01 = new RFActionListener01();
        button1.addActionListener(rfActionListener01);
        RFActionListener02 rfActionListener02 = new RFActionListener02();
        button2.addActionListener(rfActionListener02);
        // 创建一个垂直盒子容器, 把上面 6 个 JPanel 串起来作为内容面板添加到窗口
        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(panel01);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(panel02);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(panel03);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(panel04);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(panel05);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(panel06);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(button1);

        vBox.add(button2);

        jf.setContentPane(vBox);
        jf.setSize(1000, 1000);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    FMPerson getPersonFromText() {
        FMPerson fmPerson = new FMPerson();
        fmPerson.setUserName(text1.getText());
        fmPerson.setPswd(new String(text2.getPassword()));
        fmPerson.setNumberId(text3.getText());
        fmPerson.setPhoneNumber(text4.getText());
        fmPerson.setGender(text5.getText());
        fmPerson.setMoney(2000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmPerson.setBirthDate(sdf.parse(text6.getText()));
        } catch (Exception ex) {
            ex.printStackTrace();
            RegisterResult.getInstance().setResult("Date Format Error");
        }
        return fmPerson;
    }

    static RegisterFrame getInstance() {
        return instance;
    }

    JFrame getJf() {
        return jf;
    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class RFActionListener01 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ClientConnection.Send("Register\n");
        System.out.println("send person to server");
        FMPerson sendPerson = RegisterFrame.getInstance().getPersonFromText();
        ClientExecute.getInstance().registerMassageSend(sendPerson);
        try {
            String result = ClientConnection.getInstance().getBufferedReader().readLine();
            RegisterResult.getInstance().setLabel01(result);
            RegisterResult.getInstance().setResult(result);

        } catch (IOException ioE) {
            ioE.printStackTrace();
        }
        RegisterFrame.getInstance().getJf().dispose();
        RegisterResult.getInstance().getJf().setVisible(true);
    }
}

class RFActionListener02 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("return to homepage");
        StartFrame.getInstance().getThisFrame().setVisible(true);
        RegisterFrame.getInstance().getJf().dispose();
    }
}


class RegisterResult extends JFrame {
    public static RegisterResult instance = new RegisterResult();
    JLabel label01;
    //int flag = 2;   //2 means failed, 1 data format error, 0 succeed
    String result = "failed";

    public void setResult(String result) {
        this.result = result;
    }

    public void setLabel01(String text) {
        this.label01.setText(text);
    }

    private JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    public static RegisterResult getInstance() {
        return instance;
    }

    public String getResult() {
        return result;
    }

    private RegisterResult() {
        jf = new JFrame("RegisterResult");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        label01 = new JLabel();
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/02.jpg"));
        Button button = new Button("OK");
        RRActionListener rrActionListener = new RRActionListener();
        button.addActionListener(rrActionListener);
        label01.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        Box vBox = Box.createVerticalBox();
        vBox.add(panel01);
        vBox.add(label01);
        vBox.add(button);
        vBox.add(label02);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class RRActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (RegisterResult.getInstance().getResult().equals("register succeed")) {
            System.out.println("go to homepage");
            RegisterResult.getInstance().getJf().dispose();
            HomePage.getInstance().refreshHomePage();
            HomePage.getInstance().getJf().setVisible(true);

        } else {
            System.out.println("return to register");
            RegisterResult.getInstance().getJf().dispose();
            RegisterFrame.getInstance().getJf().setVisible(true);
        }

    }
}

class LoginFrame extends JFrame {
    private static LoginFrame instance = new LoginFrame();
    private JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    JTextField username = new JTextField(10);
    JPasswordField password = new JPasswordField(10);

    private LoginFrame() {
        jf = new JFrame("LoginFrame");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        JLabel label01 = new JLabel();
        JLabel label001 = new JLabel();
        label001.setText("user name");
        panel01.add(label001);
        label01.setText("");
        label01.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel01.add(username);
        panel01.add(label01);
        // 第 2 个 JPanel, 使用默认的浮动布局
        JPanel panel02 = new JPanel();
        JLabel label002 = new JLabel();
        label002.setText("password");
        panel02.add(label002);
        panel02.add(password);
        JLabel label02 = new JLabel();
        label02.setText("");
        label02.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel02.add(label02);
        Button button1 = new Button("log");
        Button button2 = new Button("return");
        //因为addActionListener需要一个ActionListener，所以就要new一个出来
        LFActionListener01 lfActionListener01 = new LFActionListener01();
        button1.addActionListener(lfActionListener01);
        LFActionListener02 lfActionListener02 = new LFActionListener02();
        button2.addActionListener(lfActionListener02);
        // 创建一个垂直盒子容器, 把上面 6 个 JPanel 串起来作为内容面板添加到窗口
        Box vBox = Box.createVerticalBox();
        vBox.add(panel01);
        vBox.add(panel02);
        vBox.add(button1);
        vBox.add(button2);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    public static LoginFrame getInstance() {
        return instance;
    }

    String getUserName() {
        return username.getText();
    }

    String getPassWord() {
        return String.valueOf(password.getPassword());
    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class LFActionListener01 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ClientConnection.Send("Login\n");
        System.out.println("try login");
        String username = LoginFrame.getInstance().getUserName();
        String password = LoginFrame.getInstance().getPassWord();
        String result = null;
        boolean flag = false;
        ClientExecute.getInstance().loginMessageSend(username, password);
        try {
            result = ClientConnection.getInstance().getBufferedReader().readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (result.equals("login succeed")) {
            flag = true;
            LoginResult.getInstance().setFlag(0);
        }
        LoginResult.getInstance().setLabel01();
        LoginResult.getInstance().getJf().setVisible(true);
        LoginFrame.getInstance().getJf().dispose();


    }
}

class LFActionListener02 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("return start menu");
        StartFrame.getInstance().getThisFrame().setVisible(true);
        LoginFrame.getInstance().getJf().dispose();
    }
}


class LoginResult extends JFrame {
    private JFrame jf;

    private int flag = -1;

    public JFrame getJf() {
        return jf;
    }

    private static LoginResult instance = new LoginResult();

    public static LoginResult getInstance() {
        return instance;
    }

    JLabel label01;

    private LoginResult() {

        jf = new JFrame("LogicResult");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        label01 = new JLabel();
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/01.jpg"));
        Button button = new Button("OK");
        LRActionListener lrActionListener = new LRActionListener();
        button.addActionListener(lrActionListener);

        label01.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        Box vBox = Box.createVerticalBox();
        vBox.add(panel01);
        vBox.add(label01);
        vBox.add(button);
        vBox.add(label02);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setLabel01() {
        if (flag == 0) {
            label01.setText("Login Successfully!");
        } else {
            label01.setText("Login Failed!");
        }
    }

    public int getFlag() {
        return flag;
    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class LRActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (LoginResult.getInstance().getFlag() == 0) { //login successfully, you will go to home page
            System.out.println("home page ");
            LoginResult.getInstance().getJf().dispose();
            HomePage.getInstance().refreshHomePage();
            HomePage.getInstance().getJf().setVisible(true);
        } else { //  back to the start menu
            System.out.println("start menu");
            LoginResult.getInstance().getJf().dispose();
            StartFrame.getInstance().getThisFrame().setVisible(true);
        }

    }
}

class HomePage extends JFrame {     //TODO: QUERY the person and show on screen
    private JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    private static HomePage instance = new HomePage();

    public static HomePage getInstance() {
        return instance;
    }

    JLabel balanceLabel = new JLabel("UNKNOWN");
    private HomePage() {
        jf = new JFrame("HomePage");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label02 = new JLabel();
        label02.setText("Account Balance:");
        label02.setFont(new Font(null, Font.PLAIN, 35));  // 设置字体，null 表示使用默认字体

        balanceLabel.setFont(new Font(null, Font.PLAIN, 40));  // 设置字体，null 表示使用默认字体
        Button button1 = new Button("Deposit");     //存款
        Button button2 = new Button("Withdrawal");  //提款
        Button button3 = new Button("Transfer");
        Button button4 = new Button("Modify personal information");
        Button button5 = new Button("log out");
        //因为addActionListener需要一个ActionListener，所以就要new一个出来
        HPActionListener01 hpActionListener01 = new HPActionListener01();
        button1.addActionListener(hpActionListener01);
        HPActionListener02 hpActionListener02 = new HPActionListener02();
        button2.addActionListener(hpActionListener02);
        HPActionListener03 hpActionListener03 = new HPActionListener03();
        button3.addActionListener(hpActionListener03);
        HPActionListener04 hpActionListener04 = new HPActionListener04();
        button4.addActionListener(hpActionListener04);
        HPActionListener05 hpActionListener05 = new HPActionListener05();
        button5.addActionListener(hpActionListener05);
        Box vBox = Box.createVerticalBox();
// 创建一个垂直盒子容器, 把上面 6 个 JPanel 串起来作为内容面板添加到窗口
        vBox.add(label02);
        vBox.add(balanceLabel);
        vBox.add(button1);
        vBox.add(button2);
        vBox.add(button3);
        vBox.add(button4);
        vBox.add(button5);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    void refreshHomePage(){
        ClientConnection.Send("Personal Homepage\n");
        FMPerson homepagePerson = ClientExecute.getInstance().personalHomePageReceive();
        Double moneyNow = homepagePerson.getMoney();
        setBalanceLabel(moneyNow.toString());
    }

    void setBalanceLabel(String text){
        balanceLabel.setText(text);
    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class HPActionListener01 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Deposit");
        ChangeMoney.getInstance().setDeposit(true);
        ChangeMoney.getInstance().changeLabel(true);
        HomePage.getInstance().getJf().dispose();
        ChangeMoney.getInstance().getJf().setVisible(true);
        ClientConnection.Send("Change Money\n");
    }
}

class HPActionListener02 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Withdrawal");
        ChangeMoney.getInstance().setDeposit(false);
        ChangeMoney.getInstance().changeLabel(false);
        HomePage.getInstance().getJf().dispose();
        ChangeMoney.getInstance().getJf().setVisible(true);
        ClientConnection.Send("Change Money\n");
    }
}

class HPActionListener03 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("transfer");
        HomePage.getInstance().getJf().dispose();
        TransferAccount.getInstance().getJf().setVisible(true);
        ClientConnection.Send("Transfer Account\n");
    }
}

class HPActionListener04 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("change personal information");
        HomePage.getInstance().getJf().dispose();
        ChangeInformation.getInstance().getJf().setVisible(true);
        ClientConnection.Send("Change Personal Information\n");
    }
}

class HPActionListener05 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("logout");
        System.exit(0);
    }
}


class ChangeMoney extends JFrame {
    private boolean deposit;
    JTextField money = new JTextField(25);

    public void setDeposit(boolean deposit) {
        this.deposit = deposit;
    }

    JLabel label001;
    private JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    private static ChangeMoney instance = new ChangeMoney();

    public static ChangeMoney getInstance() {
        return instance;
    }

    private ChangeMoney() {
        jf = new JFrame("ChangeMoney");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        JLabel label01 = new JLabel();
        label001 = new JLabel();
        if (deposit) {
            label001.setText("Deposit");
        } else {
            label001.setText("Withdrawal");
        }

        panel01.add(label01);
        panel01.add(label001);
        label01.setText("please enter the amount");
        label001.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel01.add(money);
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/03.jpg"));
        Button button = new Button("OK");
        //因为addActionListener需要一个ActionListener，所以就要new一个出来
        CMActionListener cmActionListener = new CMActionListener();
        button.addActionListener(cmActionListener);
        Box vBox = Box.createVerticalBox();
        vBox.add(label001);
        vBox.add(label01);
        vBox.add(panel01);
        vBox.add(button);
        vBox.add(label02);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    void changeLabel(boolean isDeposit){
        if(isDeposit){
            label001.setText("Deposit");
        } else {
            label001.setText("Withdrawal");
        }
    }
    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    class CMActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Double amount = Math.abs(Double.parseDouble(money.getText()));
            if (!deposit) {
                amount = -1.0 * amount;
            }
            ClientExecute.getInstance().changeMoneySend(amount);
            try {
                String result = ClientConnection.getInstance().getBufferedReader().readLine();
                ChangeResult.getInstance();
                System.out.println(result);
                if (result.equals("succeed")) {
                    ChangeResult.getInstance().setSucceed(true);
                } else {  //  money not enough
                    ChangeResult.getInstance().setSucceed(false);
                }
                ChangeResult.getInstance().changeLabel();
                ChangeResult.getInstance().getJf().setVisible(true);
                ChangeMoney.getInstance().getJf().dispose();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}


class ChangeResult extends JFrame {
    private JFrame jf;
    boolean succeed;
    JLabel label01 = new JLabel();

    public static  ChangeResult instance = new ChangeResult();

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public JFrame getJf() {
        return jf;
    }


    public static ChangeResult getInstance() {
        return instance;
    }

    private ChangeResult() {
        jf = new JFrame("ChangeResult");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        this.changeLabel();
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/05.jpg"));
        Button button = new Button("OK");
        CRActionListener crActionListener = new CRActionListener();
        button.addActionListener(crActionListener);
        Box vBox = Box.createVerticalBox();
        vBox.add(panel01);
        vBox.add(label01);
        vBox.add(button);
        vBox.add(label02);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    void changeLabel() {
        if (succeed) {
            label01.setText("CHANGE MONEY SUCCESSFULLY");
        } else {
            label01.setText("YOUR MONEY IS NOT ENOUGH");
        }
        label01.setFont(new Font(null, Font.PLAIN, 25));
    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class CRActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ChangeResult.getInstance().getJf().dispose();
        HomePage.getInstance().refreshHomePage();
        HomePage.getInstance().getJf().setVisible(true);
    }
}

class TransferAccount extends JFrame {
    private JFrame jf;

    JTextField toId = new JTextField(10);
    JTextField amount = new JTextField(10);

    public JFrame getJf() {
        return jf;
    }

    private static TransferAccount instance = new TransferAccount();

    public static TransferAccount getInstance() {
        return instance;
    }

    private TransferAccount() {
        jf = new JFrame("TransferAccount ");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        JLabel label01 = new JLabel();
        label01.setText("transfer account               ");
        label01.setFont(new Font(null, Font.PLAIN, 25));
        JLabel label001 = new JLabel();
        label001.setText("UserId You Want To Transferred To:");
        panel01.add(label01);
        panel01.add(label001);
        panel01.add(toId);
        // 第 2 个 JPanel, 使用默认的浮动布局
        JPanel panel02 = new JPanel();
        JLabel label002 = new JLabel();
        label002.setText("Money Amount:(must be positive number)");
        panel02.add(label002);
        panel02.add(amount);
        Button button1 = new Button("OK");
        Button button2 = new Button("RETURN");
        //因为addActionListener需要一个ActionListener，所以就要new一个出来
        TAActionListener01 taActionListener01 = new TAActionListener01();
        button1.addActionListener(taActionListener01);
        TAActionListener02 taActionListener02 = new TAActionListener02();
        button2.addActionListener(taActionListener02);
        // 创建一个垂直盒子容器, 把上面 6 个 JPanel 串起来作为内容面板添加到窗口
        Box vBox = Box.createVerticalBox();
        vBox.add(label01);
        vBox.add(panel01);
        vBox.add(panel02);
        vBox.add(button1);
        vBox.add(button2);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    class TAActionListener01 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("start transfer to server");
            ClientExecute.getInstance().transferAccountSend(toId.getText(), Math.abs(Double.parseDouble(amount.getText())));
            try {
                String result = ClientConnection.getInstance().getBufferedReader().readLine();
                System.out.println(result);
                TransferResult.getInstance().setResult(result);
                TransferResult.getInstance().refreshTransferResult();
                TransferResult.getInstance().getJf().setVisible(true);
                TransferAccount.getInstance().getJf().dispose();
            } catch (IOException ioE) {
                ioE.printStackTrace();
            }
        }
    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}


class TAActionListener02 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("return homepage");
        TransferAccount.getInstance().getJf().dispose();
        HomePage.getInstance().refreshHomePage();
        HomePage.getInstance().getJf().setVisible(true);
    }
}

class TransferResult extends JFrame {
    JFrame jf;

    private String result;

    public void setResult(String result) {
        this.result = result;
    }
    JLabel label01 = new JLabel();
    public JFrame getJf() {
        return jf;
    }

    private static TransferResult instance = new TransferResult();

    public static TransferResult getInstance() {
        return instance;
    }

    private TransferResult() {
        jf = new JFrame("TransferResult ");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/04.jpg"));
        Button button = new Button("OK");
        TRActionListener trActionListener = new TRActionListener();
        button.addActionListener(trActionListener);
        label01.setText(result);
        label01.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        Box vBox = Box.createVerticalBox();
        vBox.add(panel01);
        vBox.add(label01);
        vBox.add(button);
        vBox.add(label02);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    void refreshTransferResult(){
        label01.setText(result);
    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class TRActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("return homepage");
        HomePage.getInstance().refreshHomePage();
        HomePage.getInstance().getJf().setVisible(true);
        TransferResult.getInstance().getJf().dispose();
    }
}

class ChangeInformationSelection extends JFrame {
    private JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    private static ChangeInformationSelection instance = new ChangeInformationSelection();

    public static ChangeInformationSelection getInstance() {
        return instance;
    }

    private ChangeInformationSelection() {
        jf = new JFrame("ChangeInformationSelection");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label02 = new JLabel();
        label02.setText("please select what you want to change");
        label02.setFont(new Font(null, Font.PLAIN, 20));  // 设置字体，null 表示使用默认字体
        Button button1 = new Button("user name");
        Button button2 = new Button("password");
        Button button3 = new Button("phone number");
        Button button4 = new Button("gender");
        Button button5 = new Button("birthday");
        //因为addActionListener需要一个ActionListener，所以就要new一个出来
        CISActionListener01 cisActionListener01 = new CISActionListener01();
        button1.addActionListener(cisActionListener01);
        CISActionListener02 cisActionListener02 = new CISActionListener02();
        button2.addActionListener(cisActionListener02);
        CISActionListener03 cisActionListener03 = new CISActionListener03();
        button3.addActionListener(cisActionListener03);
        CISActionListener04 cisActionListener04 = new CISActionListener04();
        button4.addActionListener(cisActionListener04);
        CISActionListener05 cisActionListener05 = new CISActionListener05();
        button5.addActionListener(cisActionListener05);
        Box vBox = Box.createVerticalBox();
// 创建一个垂直盒子容器, 把上面 6 个 JPanel 串起来作为内容面板添加到窗口
        vBox.add(label02);
        vBox.add(button1);
        vBox.add(button2);
        vBox.add(button3);
        vBox.add(button4);
        vBox.add(button5);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class CISActionListener01 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class CISActionListener02 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class CISActionListener03 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class CISActionListener04 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class CISActionListener05 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class ChangeInformation extends JFrame {
    JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    private static ChangeInformation instance = new ChangeInformation();

    public static ChangeInformation getInstance() {
        return instance;
    }

    private ChangeInformation() {
        jf = new JFrame("ChangeInformation");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        JLabel label01 = new JLabel();
        JLabel label001 = new JLabel();
        label001.setText("                what change");
        panel01.add(label01);
        panel01.add(label001);
        label01.setText("please enter new what");
        label001.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel01.add(new JTextField(25));
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/06.jpg"));
        Button button = new Button("OK");
        //因为addActionListener需要一个ActionListener，所以就要new一个出来
        CIActionListener ciActionListener = new CIActionListener();
        button.addActionListener(ciActionListener);
        Box vBox = Box.createVerticalBox();
        vBox.add(label001);
        vBox.add(label01);
        vBox.add(panel01);
        vBox.add(button);
        vBox.add(label02);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class CIActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class ChangeInformationResult extends JFrame {
    private JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    public static ChangeInformationResult instance = new ChangeInformationResult();

    public static ChangeInformationResult getInstance() {
        return instance;
    }

    private ChangeInformationResult() {
        jf = new JFrame("ChangeInformationResult");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        JLabel label01 = new JLabel();
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/07.png"));
        Button button = new Button("OK");
        CIRActionListener cirActionListener = new CIRActionListener();
        button.addActionListener(cirActionListener);
        label01.setText("");
        label01.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        Box vBox = Box.createVerticalBox();
        vBox.add(panel01);
        vBox.add(label01);
        vBox.add(button);
        vBox.add(label02);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class CIRActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class ROOTAccount extends JFrame {
    private JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    public static ROOTAccount instance = new ROOTAccount();

    public static ROOTAccount getInstance() {
        return instance;
    }

    private ROOTAccount() {
        jf = new JFrame("ROOTAccount ");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label01 = new JLabel();
        label01.setText("ROOT                        ");
        label01.setFont(new Font(null, Font.PLAIN, 20));  // 设置字体，null 表示使用默认字体
        Button button1 = new Button("Import accounts from XLS files");
        Button button2 = new Button("Export all users to users.xls");
        Button button3 = new Button("Generate PDF reports");
        Button button4 = new Button("close accounts of old people over 70 years old");
        RAActionListener01 raActionListener01 = new RAActionListener01();
        button1.addActionListener(raActionListener01);
        RAActionListener02 raActionListener02 = new RAActionListener02();
        button2.addActionListener(raActionListener02);
        RAActionListener03 raActionListener03 = new RAActionListener03();
        button3.addActionListener(raActionListener03);
        RAActionListener04 raActionListener04 = new RAActionListener04();
        button4.addActionListener(raActionListener04);
        Box vBox = Box.createVerticalBox();
// 创建一个垂直盒子容器, 把上面 6 个 JPanel 串起来作为内容面板添加到窗口
        vBox.add(label01);
        vBox.add(button1);
        vBox.add(button2);
        vBox.add(button3);
        vBox.add(button4);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    //抽取关闭监听事件出来
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class RAActionListener01 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class RAActionListener02 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class RAActionListener03 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class RAActionListener04 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class NoConnectionFrame {
    private JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    JTextField ipText;

    public static NoConnectionFrame instance = new NoConnectionFrame();

    public static NoConnectionFrame getInstance() {
        return instance;
    }

    private NoConnectionFrame() {
        jf = new JFrame("CHANGE YOUR IP ADDRESS HERE");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel titleLabel = new JLabel("");
        JLabel textLabel = new JLabel("Please input the IP address below");
        JLabel label = new JLabel("IP address:");
        ipText = new JTextField();
//        ipText.setSize(100,10);
        JButton buttonReturn = new JButton("OK");
        NCFListener ncfListener = new NCFListener();
        buttonReturn.addActionListener(ncfListener);

        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(titleLabel);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(textLabel);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(ipText);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(buttonReturn);

        jf.setSize(1000, 1000);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }

    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    String getIpaddress() {
        return ipText.getText();
    }


}

class NCFListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ClientConnection.getInstance().setServerIpAddress(NoConnectionFrame.getInstance().getIpaddress());
        ClientConnection.getInstance().initialize();
        NoConnectionFrame.getInstance().getJf().dispose();
        StartFrame.getInstance().getThisFrame().setVisible(true);
        GUIFrames.getInstance().setMainSocket(ClientConnection.getInstance().getMainSocket());
    }
}