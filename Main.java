import java.util.*;

public class Main{
    
    public static void main(String[]args) throws Exception
    {
        
        Student person = new Student("Emmad Kashmir", 111);
        person.addCourse("Math", "Ryan Utke");
        person.addCourse("biology", "Mr. Dolittle");
        person.addCourse("Computer Science", "Professor Arnow");
        person.addCourse("English", "Professor Weniger");
        person.addCourse("French", "Pepe le peu");
        //biology computer science, english french
        new GUI(person);
        /*
        ArrayList<Student> students = new ArrayList<Student>();
        boolean assignmentsView = false;
        int index = -1, courseIndex = -1;
        //scanner to read input
        Scanner kybd = new Scanner(System.in);
        //present student with log in menu and read in the choice
        logInMenu(kybd, students);
        //call logIn method for existing users, returns user's index 
        try{
            index = logIn(kybd, students);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        //present user and course info and menu of choices
        while(true)
        {
            try{
                assignmentsView = coursesMenu(kybd, students, index, assignmentsView);
                //if user chooses to open a specific course, ask user for course name and open it
                if(assignmentsView)
                {
                    courseIndex = openCourse(kybd, students, index);
                    //if index is -1, set the assignment view to false to return into course menu loop
                    if(courseIndex < 0){
                        assignmentsView = false;
                    }
                    //if course index was found,start looping on the assignments view for the course
                }
                while(assignmentsView)
                {
                    //if user chooses to go bakc into course view, assignment view should be set to false
                    assignmentsView = assignmentsMenu(kybd, students, index, courseIndex);
                }
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }*/
    }

    //method to add a grade into existing assignment
    public static void addAssignmentGrade(Scanner kybd, ArrayList<Student> students, int index, int courseIndex)
    {

        //Ask user to enter the name and grade for the assignment
    }

    //method to delete assignment from the course
    public static void deleteAssignment(Scanner kybd, ArrayList<Student> students, int index, int courseIndex)
    {
        String name;
        //ask the user for assignment name
        System.out.print("\nPlease enter the name of the assignment to be deleted: ");
        name = kybd.next();
        //delete assignment, if fails it will print error on its own
        students.get(index).getCourse(courseIndex).deleteAssignemnt(name);
    }

    //method to add an assignment into course
    public static void addAssignment(Scanner kybd, ArrayList<Student> students, int index, int courseIndex)
    {
        String name;
        double weight, grade;
        //prompt user to enter name, weight and grade for the new assignemtn
        System.out.print("\nPlease enter the name of the assignment: ");
        name = kybd.next();
        System.out.print("\nPlease enter the weight of the assignment: ");
        weight = kybd.nextDouble();
        System.out.print("\nPlease enter the grade of the assignment: ");
        grade = kybd.nextDouble();
        try{
            students.get(index).getCourse(courseIndex).addAssignment(name, weight, grade);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //method to show assignments view for the course and give action options
    public static boolean assignmentsMenu(Scanner kybd, ArrayList<Student> students, int index, int courseIndex)
    {
        String choice;
        //present the course assignments info
        System.out.println(students.get(index).getCourse(courseIndex));
        //give a menu of options regarding assignements inside the course
        System.out.print("\nMenu: \n1 - Add Assignment \n2 - Add grade for Assignment \n3 - Delete Assignment \n4 - Exit to Courses");
        choice = kybd.next();
        if(choice.equals("4"))
        {
            //send false to go back into courses loop
            return false;
        }
        else if(choice.equals("3"))
        {
            //call delete assignment method, return true to go back into assignment menu loop
            deleteAssignment(kybd, students, index, courseIndex);
            return true;

        }
        else if(choice.equals("2"))
        {
            //call add grade method, return true to continue assignemnt menu loop
            addAssignmentGrade(kybd, students, index, courseIndex);
            return true;
        }
        else if(choice.equals("1"))
        {
            //call add assignment method, return true to continue assignment menu loop
            addAssignment(kybd, students, index, courseIndex);
            return true;
        }
        else{
            //for any other input, say input is invalid and continue assignemtn menu loop
            System.out.println("Error: invalid input");
            return true;
        }

    }

    //method to open the course by course name, return course index in arraylist
    public static int openCourse(Scanner kybd, ArrayList<Student> students, int index)
    {
        String courseName;
        int courseIndex;
        //ask user for the course name
        System.out.println("Please enter course name: ");
        courseName = kybd.next();
        try{
            //find course's index
            courseIndex = students.get(index).getCourseIndex(courseName);
            return courseIndex;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        //if no course was found, return -1
        return -1;
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
            System.out.println(e.getMessage());
        }
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
        try{
            // to add a course
            students.get(index).addCourse(courseName, profName);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        } 
    }


    //method to present user with courses info and choice options
    public static boolean coursesMenu(Scanner kybd, ArrayList<Student> students, int index, boolean assignmentsView) throws Exception
    {
        String choice;
        System.out.println(students.get(index));
        System.out.println("Menu: \n1 - Open Course \n2 - Add Course \n3 - Delete Course \n4 - Exit");
        choice = kybd.next();
        if(choice.equals("2"))
        {
            //call add course method, returns false so that main keeps looping on courses menu
            addNewCourse(kybd, students, index);
            return false;
        }
        else if(choice.equals("3"))
        {
            //call delete course method, returns false so main keeps looping on course menu
            deleteTheCourse(kybd, students, index);
            return false;
        }
        else if(choice.equals("4"))
        {
            //close the scanner
            kybd.close();
            System.exit(0);
            return false;
        }
        else if(choice.equals("1"))
        {
            //return true, so main enters assignment menu loop
            return true;
            
        }
        //for any other input prompt to reenter 
        else{
            System.out.println("Error: invalid input");
            return false;
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
                && students.get(i).getId() == Integer.parseInt(id))
                {
                    //if student with this name and id found, return student's index
                    System.out.println("Logged in");
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
                && students.get(i).getId() == Integer.parseInt(id))
                {
                    //if student with this name and id already exist, print error and go back to log in
                    System.out.println("Error: student with this name and id already exists");
                    logInMenu(kybd, students);
                    return;
                }
        }
        //if name and id combination is unique, create Student object and add into arraylist
        students.add(new Student(name, Integer.parseInt(id)));
        return;
    }
    //present user with a choice of log in or new user account
    public static void logInMenu(Scanner kybd, ArrayList<Student> students)
    {
        String choice;
        //present oprion 1 and 2 for log in or new user
        System.out.println("\nMenu: \n1 - Log in\n2 - New Student\n3 - Exit\n");
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
            //close the scanner
            kybd.close();
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
