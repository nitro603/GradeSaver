import java.util.ArrayList;

public class Student {
    
    private String name;
    private int id;
    private int numberOfCourses;
    private ArrayList<Course> courses = new ArrayList<Course>;

    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;
        numberOfCourses = 0;
    }

    //method to add a course into course list
    //update the nubmer of courses that student has
    public void addCourse(String courseName, Stirng profName)
    {
        courses.add(new Course(courseName, profName));
        numberOfCourses++;
    }
    //method to delete a course 
    public void deleteCourse(String courseName)
    {
        int index;

        try{
             //find the course's index by its name
             index = getCourseIndex(courseName);
             //get the course by its index and delete it 
             

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //method to get course by its index
    public Course getCourse(int index)
    {
        //if index is -1, then course was not found
        //throw the exception
        if(index < 0)
        {
            throw new Exception("Error: course was not found");
        }
        else{
            return courses(i);
        }
    }
    //method to get course by course's name
    public int getCourseIndex(String courseName)
    {
        //loop thorugh array list of courses
        for(int i = 0; i < numberOfCourses; i++)
        {
            //if course has the same name return its index
            if(courses(i).getName().equals(courseName))
            {
                return i;
            }
        }
        //if no course is found, return -1
        return -1;
    }
    //method to get name
    public String getName()
    {
        return name;
    }
    //method to get id
    public int getId() 
    {
        return id;
    }
    //method to get the nubmer of courses
    public int getNumberOfCourses()
    {
        return numberOfCourses;
    }

}
