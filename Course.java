
import java.util.*;

public class Course {

    private String courseName;
    private String profName;
    private double courseGrade;
    private ArrayList<Assignment> assignments = new ArrayList<Assignment>();  

    //constructor for when the course name and professor are given
    public Course(String courseName, String profName){

        this.courseName = courseName;
        this.profName = profName;
        this.courseGrade = 0;
    }
    //constructor for when only course name is given
    public Course(String courseName)
    {
        this(courseName, "");
    }

    //method to create and add the assignment to assignment array and update grade for the course
    //when adding assignments, throw exception if assignment with such name exists
    public void addAssignment(String name, double weigth, double grade) throws Exception 
    {
        //loop through existing assignments, checking if assignement name is already taken
        for(int i = 0; i < assignments.size(); i++)
        {
            //if assignment has the same name as another, throw exception
            if(assignments.get(i).getName().equals(name))
            {
                throw new Exception("Error: assignment " + name + " already exists");
            }
        }
        //create an assignment and add it to arraylist
        assignments.add(new Assignment(name, weight, grade));
        courseGrade = calculateGrade();
    }
    //method to delete assignment from the array and update course grade
    //if assignment was not found, throw exception
    public void deleteAssignemnt(String name) throws Exception
    {
        int index;
        try{
            index = getAssignmentIndex(name);
            assignments.remove(index);
            courseGrade = calculateGrade();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    //get assignment by index
    public Assignment getAssignment(int index)
    {
        return assignments.get(index);
    }

    //method to find assignment index by its name
    public int getAssignmentIndex(String name) throws Exception
    {
        //loop thorugh array list of assignments
        for(int i = 0; i < assignments.size(); i++)
        {
            //if assignment has the same name as the one requested, return its index
            if(assignments.get(i).getName().equals(name))
            {
                return i;
            }
        }
        //if no assignement is found, throw exception
        throw new Exception("Error: assignment " + name + " was not found");
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

    //setter for profName
    public void setProfName(String profName)
    {
        this.profName = profName;
    }
    //setter for courseName
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
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
        return "Course: " + this.courseName + "\nProfessor: " + this.profName 
        + "\nGrade: " + this.courseGrade 
        + "\nAssignments: " + assignmentsInfo;
    }
} 