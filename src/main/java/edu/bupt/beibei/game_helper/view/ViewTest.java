package edu.bupt.beibei.game_helper.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * liujun 2018/6/14 下午2:32
 * liujun36@maoyan.com
 **/
public class ViewTest {


    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("系统登录界面");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
        f.setSize(400, 400);
        f.setLocation(200, 200);
        Container con = f.getContentPane();//生成一个容器
        con.setLayout(new GridLayout(7, 1));
        JPanel pan1 = new JPanel();//生成一个新的版面
        JLabel title = new JLabel("欢迎登陆本系统");
        title.setFont(new Font("宋体", Font.BOLD, 20));
        pan1.add(title);
        con.add(pan1);
        JPanel pan2 = new JPanel();//生成一个新的版面
        JLabel name = new JLabel("用户名");
        pan2.add(name);
        TextField tf_name = new TextField(20);
        tf_name.setText("请在此处输入用户名");
        pan2.add(tf_name);
        con.add(pan2);
        JPanel pan3 = new JPanel();//生成一个新的版面
        JLabel pass = new JLabel("密码");
        pan3.add(pass);
        JPasswordField password = new JPasswordField(15);
        password.setEchoChar('*');
        pan3.add(password);
        con.add(pan3);
        JPanel pan4 = new JPanel();
        JButton b_log = new JButton("登陆");
//        b_log.
        pan4.add(b_log);
        JButton b_exit = new JButton("退出");
        pan4.add(b_exit);
        con.add(pan4);
//        JPanel pan5 = new JPanel();
//        con.add(pan5);
//        JPanel pan6 = new JPanel();
//        con.add(pan6);
//        JPanel pan7 = new JPanel();
//        con.add(pan7);
    }

}