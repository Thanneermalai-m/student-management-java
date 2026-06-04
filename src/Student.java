public class Student {

    private int rollNo;
    private String name;
    private double marks;
    private String grade;

    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        calculateGrade();
    }

    private void calculateGrade() {
        if (marks >= 90)
            grade = "A";
        else if (marks >= 80)
            grade = "B";
        else if (marks >= 70)
            grade = "C";
        else if (marks >= 60)
            grade = "D";
        else
            grade = "F";
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        calculateGrade();
    }

    @Override
    public String toString() {
        return String.format("%-10d %-20s %-10.2f %-10s",
                rollNo, name, marks, grade);
    }
}