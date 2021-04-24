import java.util.*;

public class Main{
    
    public static void main(String[] args){
        
        new GUI();
        
        //scanner to read input
        Scanner kybd = new Scanner(System.in);
        //present student with log in menu and read in the choice
        logInMenu(kybd);

        kybd.close();
    }

    //method to create new user, called out of the logInMenu
    public static void createNewUser(Scanner kybd)
    {
        //ask user to print name and id
        System.out.println("Please enter a name and ID for new user account");

    }
    //present user with a choice of log in or new user account
    public static void logInMenu(Scanner kybd)
    {
        String choice;
        //present oprion 1 and 2 for log in or new user
        System.out.println("Menu: \n1 - Log in\n2 - New Student");
        choice = kybd.next();
        //if user wants to create new account, call new account method
        if(choice.equals(2))
        {
            createNewUser(kybd);
        }
        //if user wants to log in, call log in method from main
        else if(choice.equals(1))
        {
            return;
        }
        //if other numbers were entered, prompt to change the choice to 1 or 2
        else{
            System.out.println("Error: invalid choice");
            //call logInMenu again
            logInMenu();
        }
    }
    
   
}
