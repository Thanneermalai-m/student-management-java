import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {

        for (Student s : students) {
            if (s.getRollNo() == student.getRollNo()) {
                System.out.println("Roll Number Already Exists!");
                return;
            }
        }

        students.add(student);
        System.out.println("Student Added Successfully.");
    }

    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Student Records Found.");
            return;
        }

        System.out.println("\n--------------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s\n",
                "Roll No", "Name", "Marks", "Grade");
        System.out.println("--------------------------------------------------------");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student searchStudent(int rollNo) {

        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                return s;
            }
        }

        return null;
    }

    public void deleteStudent(int rollNo) {

        Student student = searchStudent(rollNo);

        if (student != null) {
            students.remove(student);
            System.out.println("Student Deleted Successfully.");
        } else {
            System.out.println("Student Not Found.");
        }
    }

    public void updateStudent(int rollNo,
                              String newName,
                              double newMarks) {

        Student student = searchStudent(rollNo);

        if (student != null) {

            student.setName(newName);
            student.setMarks(newMarks);

            System.out.println("Student Updated Successfully.");
        } else {
            System.out.println("Student Not Found.");
        }
    }

    public void sortByMarks() {

        students.sort(
                Comparator.comparingDouble(Student::getMarks)
                        .reversed());

        System.out.println("Students Sorted By Marks.");
    }
}