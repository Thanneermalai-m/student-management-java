import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager =
                new StudentManager();

        ArrayList<Student> loadedStudents =
                FileHandler.loadFromFile();

        manager.getStudents().addAll(
                loadedStudents);

        System.out.println(
                "Student Management System Started");

        while (true) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort By Marks");
            System.out.println("7. Save To File");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter Roll No: ");
                    int roll =
                            sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                            "Enter Name: ");
                    String name =
                            sc.nextLine();

                    System.out.print(
                            "Enter Marks: ");
                    double marks =
                            sc.nextDouble();

                    manager.addStudent(
                            new Student(
                                    roll,
                                    name,
                                    marks));

                    break;

                case 2:

                    manager.displayStudents();
                    break;

                case 3:

                    System.out.print(
                            "Enter Roll No: ");

                    int searchRoll =
                            sc.nextInt();

                    Student found =
                            manager.searchStudent(
                                    searchRoll);

                    if (found != null) {

                        System.out.println(
                                "\nStudent Found:");

                        System.out.println(found);

                    } else {

                        System.out.println(
                                "Student Not Found.");
                    }

                    break;

                case 4:

                    System.out.print(
                            "Enter Roll No: ");

                    int updateRoll =
                            sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                            "Enter New Name: ");

                    String newName =
                            sc.nextLine();

                    System.out.print(
                            "Enter New Marks: ");

                    double newMarks =
                            sc.nextDouble();

                    manager.updateStudent(
                            updateRoll,
                            newName,
                            newMarks);

                    break;

                case 5:

                    System.out.print(
                            "Enter Roll No: ");

                    int deleteRoll =
                            sc.nextInt();

                    manager.deleteStudent(
                            deleteRoll);

                    break;

                case 6:

                    manager.sortByMarks();
                    manager.displayStudents();

                    break;

                case 7:

                    FileHandler.saveToFile(
                            manager.getStudents());

                    break;

                case 8:

                    FileHandler.saveToFile(
                            manager.getStudents());

                    System.out.println(
                            "Thank You.");

                    sc.close();
                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice.");
            }
        }
    }
}