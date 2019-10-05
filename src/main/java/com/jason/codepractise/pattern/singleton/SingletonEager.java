package com.jason.codepractise.pattern.singleton;

import javax.swing.*;
import java.awt.*;

/**
 * author: zhangkai
 * date: 2019-09-29
 * description:
 */
public class SingletonEager {
    public static void main(String[] args) {
        JFrame jf = new JFrame("饿汉单例模式测试");
        jf.setLayout(new GridLayout(1,2));
        Container container = jf.getContentPane();
        Bajie bajie = Bajie.getInstance();
        container.add(bajie);
        Bajie bajie1 = Bajie.getInstance();
        container.add(bajie1);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Bajie extends JPanel {
    private static Bajie instance = new Bajie();
    private Bajie() {
        JLabel ll = new JLabel(new ImageIcon("/Users/zhangkai/workspace/project/java/codes/src/main/java/com/jason/codepractise/pattern/singleton/Bajie.jpg"));
        this.add(ll);
    }
    public static Bajie getInstance() {
        return instance;
    }
}
