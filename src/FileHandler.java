import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    public static void saveToFile(ArrayList<Student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(FILE_NAME))) {

            for (Student s : students) {

                writer.write(
                        s.getRollNo() + "," +
                                s.getName() + "," +
                                s.getMarks());

                writer.newLine();
            }

            System.out.println("Data Saved Successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error Saving File: "
                            + e.getMessage());
        }
    }

    public static ArrayList<Student> loadFromFile() {

        ArrayList<Student> students =
                new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                int rollNo =
                        Integer.parseInt(data[0]);

                String name =
                        data[1];

                double marks =
                        Double.parseDouble(data[2]);

                students.add(
                        new Student(
                                rollNo,
                                name,
                                marks));
            }

        } catch (Exception e) {

            System.out.println(
                    "Error Loading File: "
                            + e.getMessage());
        }

        return students;
    }
}