import java.util.ArrayList;

public class Student {
    
    private String name;
    private int id;
    private int numberOfCourses;
    private ArrayList<Course> courses = new ArrayList<Course>();

    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;
        numberOfCourses = 0;
    }

    //method to add a course into course list
    //update the nubmer of courses that student has
    public void addCourse(Course course)
    {
        courses.add(course);
        numberOfCourses++;
    }
    //method to delete a course, update the number of courses
    public void deleteCourse(Course course) throws Exception
    {
        //if course is not in the arraylist, throw exception 
        if(!(courses.contains(course)))
        {
            throw new Exception("Error: course was not found");
        }
        else{
            //remove curse from arraylist and update number of courses
            courses.remove(course);
            numberOfCourses--;
        }
    }

    //method to get course by its index
    public Course getCourse(int index) throws Exception 
    {
        //if index is -1, then course was not found
        //throw the exception
        if(index < 0)
        {
            throw new Exception("Error: course was not found");
        }
        else{
            return courses.get(index);
        }
    }
    //method to get course index by course's name
    public int getCourseIndex(String courseName)
    {
        //loop thorugh array list of courses
        for(int i = 0; i < numberOfCourses; i++)
        {
            //if course has the same as the one requested, return its index
            if(courses.get(i).getCourseName().equals(courseName))
            {
                return i;
            }
        }
        //if no course is found, return -1
        return -1;
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
        return numberOfCourses;
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

    //testing

    public static void main(String[]args) {

        Student student1 = new Student("Sasha", 12345);
        Course course1 = new Course("Math", "John Smith");
        student1.addCourse(course1);

        Assignment test2 = new Assignment("Quiz", 25, 90);
        course1.addAssignment(test2);
        Assignment test1 = new Assignment("Quiz", 25, 100);
        course1.addAssignment(test1);
        try{
            course1.deleteAssignemnt(test1);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println(student1);
    }

}
