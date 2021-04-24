import java.util.*;

public class Student {
    
    private String name;
    private int id;
    private ArrayList<Course> courses = new ArrayList<Course>();

    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    //method to add a course into course list
    //when course name is not unique, an exceprion is thrown 
    public void addCourse(String name, String profName) throws Exception
    {
        //loop thorugh array list of courses
        for(int i = 0; i < courses.size(); i++)
        {
            //if course has the same as another, throw exception
            if(courses.get(i).getCourseName().equals(courseName))
            {
                throw new Exception("Error: course " + name + " already exists");
            }
        }
        courses.add(new Course(name,profName));
    }
    //method to delete a course, update the number of courses
    public void deleteCourse(String courseName) throws Exception
    {
        int index;
        //find the course index by its name, then delete the course from the found index from arraylist
        //excption will be handled if no course is found with such name
        try{
           index = getCourseIndex(courseName);
           courses.remove(index);
        }
        catch(Exception e)
        {
            System.our.println(e.getMessage());
        }
    }

    //method to get course by its index
    public Course getCourse(int index)
    {
        return courses.get(index);
    }

    //method to get course index by course's name
    public int getCourseIndex(String courseName) throws Exception
    {
        //loop thorugh array list of courses
        for(int i = 0; i < courses.size(); i++)
        {
            //if course has the same as the one requested, return its index
            if(courses.get(i).getCourseName().equals(courseName))
            {
                return i;
            }
        }
        // if course was not found, throw an exception
        throw new Exception("Erorr: course " + courseName + " was not found");
    }
    //method to get student's name
    public String getName()
    {
        return name;
    }
    //method to get student's id
    public int getId() 
    {
        return id;
    }
    //method to get the nubmer of courses
    public int getNumberOfCourses()
    {
        return courses.size();
    }
    //method to represent Student as a Stirig, returns all student's info
    public String toString()
    {
        String coursesInfo = "";
        //loop through arraylist of courses, adding them to the string
        for(int i = 0; i < courses.size(); i++)
        {
            coursesInfo += "\n" + courses.get(i).toString();
        }
        return "Name: " + this.name + "\nID: " + this.id + "\n" + coursesInfo;
    }
}
