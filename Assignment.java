
public class Assignment {
    
    //add weighted constructor that reads a text document

    private String name;
    private double weight;
    private double grade;

    //construct the assignment when the name, grade and weight are given
    public Assignment(String name, double weight, double grade) 
    {
        this.name = name;
        this.weight = weight;
        this.grade = grade;
    }
    //cunstrictor for when only name and weight is given
    public Assignment(String name, double weight)
    {
        this(name, weight, 0.0);
    }
    //constructor for when only assignment name is given
    public Assignment(String name)
    {
        this(name, 0.00, 0.0);
    }
    //method to calculate weighted grade
    public double calculateWeighted()
    {
        return (grade * weight)/100;
    }
    //method to calcualte the grade for the assignment if total and earned points known
    public double calcualteGrade(double total, double earned)
    {
        return (earned * 100) / total;
    }
    //getter for assignment name
    public String getName()
    {
        return name;
    }
    //getter for weigth
    public double getWeight()
    {
        return weight;
    }
    //getter for grade
    public double getGrade()
    {
        return grade;
    }
    //setter for name
    public void setName(String name)
    {
        this.name = name;
    }
    //setter for weight
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    //setter for grade
    public void setGrade(double grade)
    {
        this.grade = grade;
    }
    //method to return assignment as a string 
    public String toString()
    {
        return name + "\nGrade: " + grade + "\nWeight: " + weight;
    }

    public static void main(String [] Args)
    {
        Assignment test = new Assignment("Quiz", 0, 0);

        test.setWeight(25);
        test.setGrade(test.calcualteGrade(100, 90));

        System.out.println(test.getGrade());
        System.out.println(test.getWeight());
        System.out.println(test.getName());


        System.out.println(test.calculateWeighted());
    }
}