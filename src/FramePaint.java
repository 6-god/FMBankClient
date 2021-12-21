import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class FramePaint {
    FramePaint() {

    }

    void paintRegisterFrame() {
        registerFrame registerFrame = new registerFrame();
    }


}


//把监听器提取出来调用


class TestPanel {
    public static void main(String[] args) {
        new registerFrame();
    }
}

class registerFrame extends JFrame {
    public registerFrame() {
        JFrame jf = new JFrame("users register");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置窗口可视化
        jf.setVisible(true);
        //设置窗口的大小：长宽
        jf.setSize(800, 800);
        //设置窗口内部的颜色
        jf.setBackground(new Color(92, 86, 144));
        //设置窗口的初始值位置
        jf.setLocation(400, 400);
        //设置窗口的大小不可变
        jf.setResizable(false);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();
        panel01.add(new JLabel("user name"));
        JLabel label01 = new JLabel();
        label01.setText("");
        label01.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel01.add(new JTextField(10));
        panel01.add(label01);
        // 第 2 个 JPanel, 使用默认的浮动布局
        JPanel panel02 = new JPanel();
        panel02.add(new JLabel("password"));
        panel02.add(new JPasswordField(10));
        JLabel label02 = new JLabel();
        label02.setText("");
        label02.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel02.add(label02);

        JPanel panel03 = new JPanel();
        panel03.add(new JLabel("student number"));
        panel03.add(new JPasswordField(10));
        JLabel label03 = new JLabel();
        label03.setText("");
        label03.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel03.add(label03);

        JPanel panel04 = new JPanel();
        panel04.add(new JLabel("phone number"));
        panel04.add(new JPasswordField(10));
        JLabel label04 = new JLabel();
        label04.setText("");
        label04.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel04.add(label04);

        JPanel panel05 = new JPanel();
        panel05.add(new JLabel("gender"));
        panel05.add(new JPasswordField(10));
        JLabel label05 = new JLabel();
        label05.setText("");
        label05.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel05.add(label05);

        JPanel panel06 = new JPanel();
        panel06.add(new JLabel("birthday"));
        panel06.add(new JPasswordField(10));
        JLabel label06 = new JLabel();
        label06.setText("");
        label06.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        panel06.add(label06);

        Button button1 = new Button("log");
        Button button2 = new Button("return");
        //因为addActionListener需要一个ActionListener，所以就要new一个出来
        MyActionListener myActionListener = new MyActionListener();
        button1.addActionListener(myActionListener);
        // 创建一个垂直盒子容器, 把上面 6 个 JPanel 串起来作为内容面板添加到窗口
        Box vBox = Box.createVerticalBox();
        vBox.add(panel01);
        vBox.add(panel02);
        vBox.add(panel03);
        vBox.add(panel04);
        vBox.add(panel05);
        vBox.add(panel06);
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

class MyActionListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}
