
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
        return "\n" + name + "\nGrade: " + grade + "\nWeight: " + weight;
    }

    //method to check if assignment is equal to another assignment
    public boolean equals(Object obj)
    {
        boolean result = obj instanceof Assignment;
        if(!result)
            return false;
        Assignment rhs = (Assignment)obj;
        //when comparing assignments, multiply weight and grade by 100 to preserve 2 deciaml places
        // and make them ints, because comparing doubles can cause issues
        return rhs.name.equals(this.name) 
                && (int)(rhs.weight * 100) == (int)(this.weight * 100)
                && (int)(rhs.grade * 100) == (int)(this.grade * 100);
    }

}