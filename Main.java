import java.util.*;

public class Main{
    
    public static void main(String[]args)throws Exception{
        
        new GUI();
        
        //ASrrayList<Student> students = new ArrayList<Student>();
        //scanner to read input
        //Scanner kybd = new Scanner(System.in);
        //present student with log in menu and read in the choice
        //logInMenu(kybd, students);
        //call logIn method for existing users, returns user's index 
        //int index = logIn(kybd, students);
        //present user and course info and menu of choices
        //coursesMenu(kybd, students, index);
        //openCourse(kybd, students, index);
        //kybd.close();
    }

    //method to delete the course
    public static void deleteTheCourse(Scanner kybd, ArrayList<Student> students, int index)
    {
        String courseName;
        //ask user for the course name
        System.out.println("Please enter course name: ");
        courseName = kybd.next();
        //try to delete the course
        try{
            students.get(index).deleteCourse(courseName);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage())
        }

        //go back to the courses menu
        coursesMenu(kybd, students, index);
        return;
    }

    //method to add a course
    public static void addNewCourse(Scanner kybd, ArrayList<Student> students, int index)
    {
        String courseName, profName;
        //ask user for the course name and profName
        System.out.println("Please enter course name: ");
        courseName = kybd.next();
        System.out.println("Please enter Professor's name: ");
        profName = kybd.next();
        //try to add a course
            students.get(index).addCourse(courseName, profName);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        } 
        //go back to the courses menu
        coursesMenu(kybd, students, index);
        return;
    }


    //method to present user with courses info and choice options
    public static void coursesMenu(Scanner kybd, ArrayList<Student> students, int index)
    {
        String choice;
        System.out.println(students.get(index));
        System.out.println("Menu: \n1 - Open Course \n2 - Add Course \n3 - Delete Course \n4 - Exit");
        choice = kybd.next();
        if(choice.equals("2"))
        {
            //call add course method, call courses menu again
            addNewCourse(kybd, students, index);
            coursesMenu(kybd, students, index);
        }
        else if(choice.equals("3"))
        {
            //call delete course method, call courses menu again
            deleteCourse(kybd, students, index);
            coursesMenu(kybd, students, index);
        }
        else if(choice.equals("4"))
        {
            System.exit(0);
        }
        else if(choice.equals("1"))
        {
            //call open course method through main
            return;
        }
        //for any other input prompt to reenter 
        else{
            System.out.println("Error: invalid input");
            coursesMenu(kybd, students, index);
            return;
        }
    }

    //method to authenticate an existing user, return a student's index in array
    //throw exption if log in fails 
    public static int logIn(Scanner kybd, ArrayList<Student> students) throws Exception
    {
        String name, id;
        //ask user to print name and id
        System.out.print("\nPlease enter account name: ");
        name = kybd.next();
        System.out.print("\nPlease enter account ID: ");
        id = kybd.next();
        //check if the name and id already exist 
        for(int i = 0; i < students.size(); i++)
        {
            if(students.get(i).getName().equals(name)
                && students.get(i).getId().equals(id))
                {
                    //if student with this name and id found, return student's index
                    return i;
                }
        }
        //if no name id combination found, throw an exception
        throw new Exception("Error: invalid name and ID combination");
    }

    //method to create new user, called out of the logInMenu
    public static void createNewUser(Scanner kybd, ArrayList<Student> students)
    {
        String name, id;
        //ask user to print name and id
        System.out.print("\nPlease enter a name for the new account: ");
        name = kybd.next();
        System.out.print("\nPlease enter an ID for the new account: ");
        id = kybd.next();
        //check if the name and id already exist 
        for(int i = 0; i < students.size(); i++)
        {
            if(students.get(i).getName().equals(name)
                && students.get(i).getId().equals(id))
                {
                    //if student with this name and id already exist, print error and go back to log in
                    System.out.println("Error: student with this name and id already exists");
                    logInMenu(kybd, students);
                    return;
                }
        }
        //if name and id combination is unique, create Student object and add into arraylist
        students.add(new Student(name, id));
        return;
    }
    //present user with a choice of log in or new user account
    public static void logInMenu(Scanner kybd, ArrayList<Student> students)
    {
        String choice;
        //present oprion 1 and 2 for log in or new user
        System.out.println("\nMenu: \n1 - Log in\n2 - New Student\n3 - Exit");
        choice = kybd.next();
        //if user wants to create new account, call new account method
        if(choice.equals("2"))
        {
            createNewUser(kybd, students);
            //after new user is created, call log in menu again to give a chance for log in
            logInMenu(kybd, students);
            return;
        }
        //if user wants to log in, call log in method from main
        else if(choice.equals("1"))
        {
            return;
        }
        else if(choice.equals("3"))
        {
            System.exit(0);
        }
        //if other numbers were entered, prompt to change the choice to 1 or 2
        else{
            System.out.println("Error: invalid choice");
            //call logInMenu again
            logInMenu(kybd, students);
            return;
        }
    }
    
   
}
