
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;



//things to do
//add the upper part of the text in sidePanel so that you can see it 
//make textfield invisible until it appears when you press a button
//add a button to enter in grades and weight of them



public class GUI extends JFrame implements Action{

    private Student person;
    int course;

    //MAIN BUTTONS FOR CONTROL
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    //Panels that make up the JFrame
    JPanel sidePanelLeft = new JPanel();
    JPanel sidePanelRight = new JPanel();
    JPanel innerRight = new JPanel();
    JPanel top = new JPanel();

    //User input fields
    JTextField assignmentInputField = new JTextField();
    JTextField gradeInputField = new JTextField();
    JTextField weightInputField = new JTextField();

    private JButton Input = new JButton();
    private JButton exit = new JButton();

    //menu display
    JLabel menu = new JLabel();
    JLabel calcDescription;
    JLabel output;


    GUI(Student p){

        //INITIALIZATION
        this.person = p;

        //Top part of the page
        
        top.setBackground(new Color(183, 196, 186));
        top.setLayout(new GridLayout(0,1));
        top.setBounds(0,0,600,50);

        JLabel CoursesPage = new JLabel();
        CoursesPage.setText("Courses");
        CoursesPage.setVerticalAlignment(JLabel.TOP);
        CoursesPage.setHorizontalAlignment(JLabel.CENTER);

        JLabel Intro = new JLabel();
        Intro.setText("Welcome, " + person.getName() + " ID:" + person.getId());
        Intro.setHorizontalAlignment(JLabel.CENTER);

        //Left container of the page
        sidePanelLeft.setBounds(0,50,250,450);
        sidePanelLeft.setLayout(null);
        sidePanelLeft.setBackground(new Color(9, 217, 65));

        //BUTTONS on left Side Panel
        button1 = new JButton();
        button1.setBounds(10, 25, 225, 50);
        button1.addActionListener(this);
        button1.setText("Math");
        sidePanelLeft.add(button1);
    
        button2 = new JButton();
        button2.setBounds(10, 85, 225, 50);
        button2.addActionListener(this);
        button2.setText("Biology");
        button2.setFocusable(false);
        button2.setBackground(Color.lightGray);
        sidePanelLeft.add(button2);
        

        button3 = new JButton();
        button3.setBounds(10, 145, 225, 50);
        button3.addActionListener(this);
        button3.setText("Computer Science"); 
        sidePanelLeft.add(button3);

        button4 = new JButton();
        button4.setBounds(10, 205, 225, 50);
        button4.addActionListener(this);
        button4.setText("English");
        sidePanelLeft.add(button4);

        button5 = new JButton();
        button5.setBounds(10, 265, 225, 50);
        button5.addActionListener(this);
        button5.setText("French");
        sidePanelLeft.add(button5);


        //Right container of the pagel
        sidePanelRight.setBounds(250,50,350,450);
        sidePanelRight.setLayout(null);
        sidePanelRight.setBackground(new Color(50, 168, 82));

        innerRight.setBounds(250,50,350,450);
        //innerRight.setLayout(new GridLayout(null));
        innerRight.setBackground(new Color(0,10,150));
        
        menu.setBounds(75, 1, 300, 40);
        sidePanelRight.add(menu);

        calcDescription = new JLabel();
        calcDescription.setBounds(10, 30, 280,20);
        sidePanelRight.add(calcDescription);

        output = new JLabel();
        output.setBounds(10, 100, 280, 300);
        sidePanelRight.add(output);

        Input.setBounds(285, 50, 45, 25);
        Input.setText("+");
        Input.addActionListener(this);
        sidePanelRight.add(Input);


        exit.setBounds(220, 320, 80, 50);
        exit.setText("Exit");
        exit.addActionListener(this);
        exit.setVisible(false);
        sidePanelRight.add(exit);

        //sidePanelRight.add(innerRight);

        //INPUT FIELDS to add grades
        assignmentInputField.setBounds(10, 50, 150, 25);
        sidePanelRight.add(assignmentInputField);

        gradeInputField.setBounds(170, 50, 50, 25);
        sidePanelRight.add(gradeInputField);

        weightInputField.setBounds(230, 50, 50, 25);
        sidePanelRight.add(weightInputField); 

        assignmentInputField.setVisible(false);
        gradeInputField.setVisible(false);
        weightInputField.setVisible(false);
        Input.setVisible(false);

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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        assignmentInputField.setVisible(true);
        gradeInputField.setVisible(true);
        weightInputField.setVisible(true);
        Input.setVisible(true);
        menu.setVisible(true);
        calcDescription.setVisible(true);
        output.setVisible(false);


        exit.setVisible(true);
        if(e.getSource() == button1){
            course = 0;
            menu.setText("Add Grades below for: " + person.courses.get(course).getCourseName());
            calcDescription.setText("Assignment                              Grade           Weight");
            exit.setVisible(true);

        }else if(e.getSource() == button2){
            course = 1;
            menu.setText("Add Grades below for: " + person.courses.get(course).getCourseName());
            calcDescription.setText("Assignment                              Grade           Weight");
            exit.setVisible(true);

        }else if(e.getSource() == button3){
            course = 2;
            menu.setText("Add Grades below for: " + person.courses.get(course).getCourseName());
            calcDescription.setText("Assignment                              Grade           Weight");
            exit.setVisible(true);

        }else if(e.getSource() == button4){
            course = 3;
            menu.setText("Add Grades below for: " + person.courses.get(course).getCourseName());
            calcDescription.setText("Assignment                              Grade           Weight");
            exit.setVisible(true);

        }else if(e.getSource() == button5){
            course = 4;
            menu.setText("Add Grades below for: " + person.courses.get(course).getCourseName());
            calcDescription.setText("Assignment                              Grade           Weight");
            exit.setVisible(true);

        }else if(e.getSource() == Input){

            String name = assignmentInputField.getText();
            double weight = Double.parseDouble(weightInputField.getText());
            double grade = Double.parseDouble(gradeInputField.getText());

            output.setVisible(true);
            
            try {
                person.courses.get(course).addAssignment(name,weight,grade);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            output.setText("<html>" + person.courses.get(course).toString().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

        }else if(e.getSource()==exit){
            assignmentInputField.setVisible(false);
            gradeInputField.setVisible(false);
            weightInputField.setVisible(false);
            Input.setVisible(false);
            menu.setVisible(false);
            calcDescription.setVisible(false);
            output.setVisible(true);
            output.setText("<html>" + person.toString().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");;
            exit.setVisible(false);

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
