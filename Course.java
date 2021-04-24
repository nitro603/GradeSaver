//NEEDED: 
//
import java.util.*;

public class Course {

    private String courseName;
    private String professorName;
    private double courseGrade;
    private int numberOfAssignments;
    private ArrayList<Assignment> assignments = new ArrayList<Assignment>();  

    //constructor for when the course name and professor are given
    public Course(String courseName, String professorName){

        this.courseName = courseName;
        this.professorName = professorName;
        numberOfAssignments = 0;
        this.courseGrade = 0;
    }
    //constructor for when only course name is given
    public Course(String courseName)
    {
        this(courseName, "");
    }

    //method to add the assignment to assignment array and update number of assignments 
    public void addAssignment(Assignment assignment)
    {
        assignments.add(assignment);
        numberOfAssignments++;
        //update course grade
        this.courseGrade = calculateGrade();
    }
    //method to delete assignment from the array and update nubmer of assignemnts
    public void deleteAssignemnt(Assignment assignment) throws Exception
    {
        //check if assignemtn is in the array of assignments
        //if not, throw an exception
        if(!(assignments.contains(assignment)))
            throw new Exception("Error: assignment not found");
        else{
            //otherwise remove the assignment from arraylist and update number of assignments
            assignments.remove(assignment);
            numberOfAssignments--;
        }
    }

    //method to calculate the grade of the course
    public double calculateGrade()
    {
        double grade = 0;
        double weights = 0;
        //loop through assignments adding up grades * weights and summing up weights
        for(int i = 0; i < assignments.size(); i++)
        {
            grade += assignments.get(i).getGrade() * assignments.get(i).getWeight();
            weights += assignments.get(i).getWeight();
        }
        return (grade / weights);
    }
    public String getCourseName(){
        return this.courseName;
    }

    public String getProfessorName(){
        return this.professorName;
    }

    public double getCourseGrade(){
        return this.courseGrade;
    }

    //method to print course as a String, returns all course information
    public String toString()
    {
        String assignmentsInfo = "";
        //loop through assignments arraylist, adding them to the string
        for(int i = 0; i < assignments.size(); i++)
        {
            assignmentsInfo += "\n" + assignments.get(i).toString();
        }
        return "Course: " + this.courseName + "\nProfessor: " + this.professorName 
        + "\nGrade: " + this.courseGrade 
        + "\nAssignments: " + this.numberOfAssignments 
        + assignmentsInfo;
    }


    //test
    public static void main(String[] args)
    {
        Course course1 = new Course("Calc", "Jane Doe");
        Assignment test1 = new Assignment("Quiz", 25, 100);
        Assignment test2 = new Assignment("Test", 50, 70);

        course1.addAssignment(test1);
        course1.addAssignment(test2);

        System.out.println(course1);
    }
} 