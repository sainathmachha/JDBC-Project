import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentsService {

    public static void Execute() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input;
        try {
            System.out.println("1. Display");
            System.out.println("2. Add");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            input = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        switch (input) {
            case 1:
                //Display the data
                StudentsDAO.showStudents();
                break;
            case 2:
                StudentsDAO.insertIntoStudents();
                break;
            case 3:
                //Update the data
                StudentsDAO.updateStudent();
                break;
            case 4:
                //delete the data
                StudentsDAO.deleteStudent();
                break;
            case 5:
                System.out.println("Thanks for using the application 🫂. See ya...");
                System.exit(0);
        }
    }
}
