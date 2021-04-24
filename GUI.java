
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
    
    GUI(){
        //Top part of the page
        JPanel top = new JPanel();
        top.setBackground(new Color(120,100,159));
        top.setLayout(new GridLayout(0,1));
        top.setBounds(0,0,500,50);

        JLabel CoursesPage = new JLabel();
        CoursesPage.setText("Courses");
        CoursesPage.setVerticalAlignment(JLabel.TOP);
        CoursesPage.setHorizontalAlignment(JLabel.CENTER);

        JLabel Intro = new JLabel();
        Intro.setText("Welcome, " + "Sasha K");
        Intro.setHorizontalAlignment(JLabel.CENTER);

        //sidepart of the page
        JPanel sidePanel = new JPanel();
        sidePanel.setBounds(0,51,500,450);
        sidePanel.setBackground(new Color(100,50,150));
        

        setTitle("GradeSaver");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,500);
        setVisible(true);
        top.add(CoursesPage);
        top.add(Intro);
        add(sidePanel);
        add(top);
        
        ImageIcon image = new ImageIcon("sus.png");
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(3,50,250));

    }

}
