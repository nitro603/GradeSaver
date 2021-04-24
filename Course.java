//NEEDED: 
//
//
//write getters for course name and professor name
import java.util.*;

public class Course {

    private String courseName, professorName;
    private double courseGrade;
    private ArrayList<Assignment> courseAssignments = new ArrayList<Assignment>();  

    public Course(String name, String professor){
        this.courseName = name;
        this.professorName = professor;
        this.grade = 0;
    }

    public String getCourseName(){
        return this.CourseName;
    }

    public String getProfessorName(){
        return this.professorName;
    }

    public double getCourseGrade(){
        return this.courseGrade;
    }
} 