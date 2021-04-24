
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class GUI extends JFrame implements Action{
    
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;


    GUI(){
        //Top part of the page
        JPanel top = new JPanel();
        top.setBackground(new Color(120,100,159));
        top.setLayout(new GridLayout(0,1));
        top.setBounds(0,0,600,50);

        JLabel CoursesPage = new JLabel();
        CoursesPage.setText("Courses");
        CoursesPage.setVerticalAlignment(JLabel.TOP);
        CoursesPage.setHorizontalAlignment(JLabel.CENTER);

        JLabel Intro = new JLabel();
        Intro.setText("Welcome, " + "Emmad Kashmiri");
        Intro.setHorizontalAlignment(JLabel.CENTER);

        //Left container of the page
        JPanel sidePanelLeft = new JPanel();
        sidePanelLeft.setBounds(0,50,250,450);
        sidePanelLeft.setLayout(null);
        sidePanelLeft.setBackground(new Color(100,50,150));

        //Right container of the pagel
        JPanel sidePanelRight = new JPanel();
        sidePanelRight.setBounds(250,50,350,450);
        sidePanelRight.setLayout(null);
        sidePanelRight.setBackground(new Color(120,40,200));

        JLabel menu = new JLabel();
        menu.setBounds(250, 50, 50, 40);
        sidePanelRight.add(menu);

        button1 = new JButton();
        button1.setBounds(10, 25, 225, 50);
        button1.addActionListener(e -> menu.setText("<html>Hello World!<br/>blahblahblah</html>"));
        button1.setText("Math");
        sidePanelLeft.add(button1);

        button2 = new JButton();
        button2.setBounds(10, 85, 225, 50);
        button2.setText("Biology");
        button2.setFocusable(false);
        button2.setBackground(Color.lightGray);
        sidePanelLeft.add(button2);

        button3 = new JButton();
        button3.setBounds(10, 145, 225, 50);
        button3.setText("Computer Science"); 
        sidePanelLeft.add(button3);

        button4 = new JButton();
        button4.setBounds(10, 205, 225, 50);
        button4.setText("English");
        sidePanelLeft.add(button4);

        button5 = new JButton();
        button5.setBounds(10, 265, 225, 50);
        button5.setText("French");
        sidePanelLeft.add(button5);

    

        setTitle("GradeSaver");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600,500);
        setVisible(true);
        top.add(CoursesPage);
        top.add(Intro);
        add(sidePanelLeft);
        add(sidePanelRight);
        add(top);   
        
        ImageIcon image = new ImageIcon("sus.png");
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(3,50,250));

    }

    //if you aren't overriding correctly this makes the compiler tell you
    protected void paintComponent(Graphics gr){

        gr.drawString("string literal or a string variable", 0,10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            JLabel menu = new JLabel();
            menu.setText("Add Grades below");
            //sidePanelRight.add(menu);
        }
    }

    @Override
    public Object getValue(String key) {
        // TODO Auto-generated method stub
        
        return null;
    }

    @Override
    public void putValue(String key, Object value) {
        // TODO Auto-generated method stub
        
    }

}
