//把监听器提取出来调用

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestPanel {
    public static void main(String[] args) {
        //new RegisterFrame();
        StartFrame.getInstance();
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
    }
}



class StartFrame extends JFrame {
    public static StartFrame instance = new StartFrame();
    JFrame jf;
    private StartFrame() {
        jf = new JFrame("StartFrame");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel title = new JLabel("Fei Ma Bank");
        Font font = new Font("Times New Roman",Font.PLAIN,50);
        title.setFont(font);
        Button button1 = new Button("Register");
        button1.setSize(100,5);
        Button button2 = new Button("Login");
        button2.setSize(100,5);
        Button button3 = new Button("Administrator");
        button3.setSize(100,5);
        //因为addActionListener需要一个ActionListener，所以就要new一个出来
        SFActionListener01 sfActionListener01 = new SFActionListener01();
        button1.addActionListener(sfActionListener01);
        // 创建一个垂直盒子容器, 把上面 6 个 JPanel 串起来作为内容面板添加到窗口
        SFActionListener02 sfActionListener02 = new SFActionListener02();
        button2.addActionListener(sfActionListener02);
        SFActionListener03 sfActionListener03 = new SFActionListener03();
        button3.addActionListener(sfActionListener03);
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
        Box baseBox = Box.createHorizontalBox();
        baseBox.add(Box.createHorizontalStrut(30));
        baseBox.add(vBox);
        baseBox.add(Box.createHorizontalStrut(30));

        jf.setContentPane(baseBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setSize(150,300);
        jf.setBounds(400,300,500,500);
        jf.setVisible(true);
        windowClose(jf);

    }
    static StartFrame getInstance(){
        return instance;
    }


    JFrame getThisFrame(){
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
        System.out.println("aaa");
        RegisterFrame.getInstance().getJf().setVisible(true);
        StartFrame.getInstance().getThisFrame().dispose();
    }
}

class SFActionListener02 implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aab");
        LoginFrame.getInstance().getJf().setVisible(true);
        StartFrame.getInstance().getThisFrame().dispose();
    }
}

class SFActionListener03 implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aac");
    }
}


class RegisterFrame extends JFrame {
    private static RegisterFrame instance = new RegisterFrame();
    JFrame jf;
    private RegisterFrame() {
        jf = new JFrame("Users Login:");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        panel01.add(new JLabel("User Name:"));
        JLabel label01 = new JLabel();
        label01.setText("");
        label01.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel01.add(new JTextField(10));
        panel01.add(label01);
        // 第 2 个 JPanel, 使用默认的浮动布局
        JPanel panel02 = new JPanel();
        panel02.add(new JLabel("Password:"));
        panel02.add(new JPasswordField(10));
        JLabel label02 = new JLabel();
        label02.setText("");
        label02.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel02.add(label02);

        JPanel panel03 = new JPanel();
        panel03.add(new JLabel("Student Number:"));
        panel03.add(new JPasswordField(10));
        JLabel label03 = new JLabel();
        label03.setText("");
        label03.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel03.add(label03);

        JPanel panel04 = new JPanel();
        panel04.add(new JLabel("Phone Number:"));
        panel04.add(new JPasswordField(10));
        JLabel label04 = new JLabel();
        label04.setText("");
        label04.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel04.add(label04);

        JPanel panel05 = new JPanel();
        panel05.add(new JLabel("Gender:"));
        panel05.add(new JPasswordField(10));
        JLabel label05 = new JLabel();
        label05.setText("");
        label05.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel05.add(label05);

        JPanel panel06 = new JPanel();
        panel06.add(new JLabel("Birthday:"));
        panel06.add(new JPasswordField(10));
        JLabel label06 = new JLabel();
        label06.setText("");
        label06.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel06.add(label06);

        Button button1 = new Button("LOGIN");
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
        jf.setSize(1000,1000);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        windowClose(jf);

    }
    static RegisterFrame getInstance(){
        return instance;
    }

    JFrame getJf(){
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
        System.out.println("aaa");
    }
}

class RFActionListener02 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aba");
        StartFrame.getInstance().getThisFrame().setVisible(true);
        RegisterFrame.getInstance().getJf().dispose();
    }
}


class RegisterResult extends JFrame {
    public RegisterResult() {
        JFrame jf = new JFrame("RegisterResult");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        JLabel label01 = new JLabel();
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/02.jpg"));
        Button button = new Button("confirm");
        RRActionListener rrActionListener = new RRActionListener();
        button.addActionListener(rrActionListener);
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

class RRActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class LoginFrame extends JFrame {
    private static LoginFrame instance = new LoginFrame();
    private JFrame jf;
    public JFrame getJf() {
        return jf;
    }

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
        panel01.add(new JTextField(10));
        panel01.add(label01);
        // 第 2 个 JPanel, 使用默认的浮动布局
        JPanel panel02 = new JPanel();
        JLabel label002 = new JLabel();
        label002.setText("password");
        panel02.add(label002);
        panel02.add(new JPasswordField(10));
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

    public static LoginFrame getInstance(){
        return instance;
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
        System.out.println("aaa");

    }
}

class LFActionListener02 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
        StartFrame.getInstance().getThisFrame().setVisible(true);
        LoginFrame.getInstance().getJf().dispose();
    }
}


class LoginResult extends JFrame {
    private JFrame jf;
    public JFrame getJf() {
        return jf;
    }
    private static LoginResult instance = new LoginResult();
    public static LoginResult getInstance() {
        return instance;
    }

    private LoginResult() {
        jf = new JFrame("LogicResult");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        JLabel label01 = new JLabel();
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/01.jpg"));
        Button button = new Button("confirm");
        LRActionListener lrActionListener = new LRActionListener();
        button.addActionListener(lrActionListener);
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

class LRActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class HomePage extends JFrame {
    private JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    private static HomePage instance = new HomePage();

    public static HomePage getInstance() {
        return instance;
    }

    private HomePage() {
        jf = new JFrame("HomePage");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label02 = new JLabel();
        label02.setText("account");
        label02.setFont(new Font(null, Font.PLAIN, 10));  // 设置字体，null 表示使用默认字体
        JLabel label01 = new JLabel();
        label01.setText("");
        label01.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        Button button1 = new Button("save");
        Button button2 = new Button("draw");
        Button button3 = new Button("transfer accounts");
        Button button4 = new Button("modify personal information");
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
        vBox.add(label01);
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

class HPActionListener01 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class HPActionListener02 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class HPActionListener03 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class HPActionListener04 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class HPActionListener05 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class ChangeMoney extends JFrame {
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
        JLabel label001 = new JLabel();
        label001.setText("save or draw");
        panel01.add(label01);
        panel01.add(label001);
        label01.setText("please enter the amount");
        label001.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel01.add(new JTextField(25));
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/03.jpg"));
        Button button = new Button("confirm");
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

class CMActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class ChangeResult extends JFrame {
    private JFrame jf;

    public JFrame getJf() {
        return jf;
    }

    private static ChangeResult instance = new ChangeResult();

    public static ChangeResult getInstance() {
        return instance;
    }

    private ChangeResult() {
        JFrame jf = new JFrame("ChangeResult");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        JLabel label01 = new JLabel();
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/05.jpg"));
        Button button = new Button("confirm");
        CRActionListener crActionListener = new CRActionListener();
        button.addActionListener(crActionListener);
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

class CRActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class TransferAccount extends JFrame {
    private JFrame jf;

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
        label001.setText("Counterparty account name");
        panel01.add(label01);
        panel01.add(label001);
        panel01.add(new JPasswordField(10));
        // 第 2 个 JPanel, 使用默认的浮动布局
        JPanel panel02 = new JPanel();
        JLabel label002 = new JLabel();
        label002.setText("password");
        panel02.add(label002);
        panel02.add(new JPasswordField(10));
        Button button1 = new Button("confirm");
        Button button2 = new Button("return");
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

class TAActionListener01 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class TAActionListener02 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}

class TransferResult extends JFrame {
    JFrame jf;

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
        JLabel label01 = new JLabel();
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/04.jpg"));
        Button button = new Button("confirm");
        TRActionListener trActionListener = new TRActionListener();
        button.addActionListener(trActionListener);
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

class TRActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
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
        Button button = new Button("confirm");
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
    JFrame jf;

    public JFrame getJf() {
        return jf;
    }



    public ChangeInformationResult() {
        jf = new JFrame("ChangeInformationResult");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel01 = new JPanel();
        JLabel label01 = new JLabel();
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("img/07.png"));
        Button button = new Button("confirm");
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
    public ROOTAccount() {
        JFrame jf = new JFrame("ROOTAccount ");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label01 = new JLabel();
        label01.setText("ROOT                        ");
        label01.setFont(new Font(null, Font.PLAIN, 20));  // 设置字体，null 表示使用默认字体
        Button button1 = new Button("Import accounts from XLS files");
        Button button2 = new Button("Export all users to users.xls");
        Button button3 = new Button("Generating PDF reports");
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
