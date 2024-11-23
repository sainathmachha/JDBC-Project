import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class StudentsDAO {

    public static boolean insertIntoStudents() {

        boolean flag = false;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter id: ");
            int id = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Enter first name: ");
            String firstName = bufferedReader.readLine();

            System.out.println("Enter last name: ");
            String lastName = bufferedReader.readLine();

            StudentsEntity studentsEntity = new StudentsEntity(id, firstName, lastName);

            Connection connection = MysqlConnection.createConnection();

            String query = "insert into students(id, firstName, lastName) values (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentsEntity.getId());
            preparedStatement.setString(2, studentsEntity.getFirstName());
            preparedStatement.setString(3, studentsEntity.getLastName());

            preparedStatement.executeUpdate();
            flag = true;
            System.out.println("Added Successfully 👍");
            showStudents();
            connection.close();
        } catch (Exception e) {
            System.out.println("Failed to add 😓");
            System.out.println(e.getMessage());
        }
        return flag;
    }

    @SuppressWarnings("unused")
	public static void showStudents(){
        try{
            Connection connection = MysqlConnection.createConnection();
            String Query = "Select * from Students";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Query);
            if(true){
                while(rs.next()) {
                    System.out.printf(" %s  %s  %s \n", rs.getInt(1), rs.getString(2), rs.getString(3));
                }
            }
            else{
            	System.out.println("No records found 😶");
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String deleteStudent(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the ID you want to delete: ");
            int id = Integer.parseInt(bufferedReader.readLine());
            Connection connection = MysqlConnection.createConnection();
            String Query = "DELETE FROM STUDENTS WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Deleted Successfully 😄.");
            showStudents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Failed to delete😓";
    }

    public static String updateStudent(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the ID you want to update: ");
            int id = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter the first name you want to update: ");
            String firstName = bufferedReader.readLine();
            System.out.println("Enter the last name you want to update: ");
            String lastName = bufferedReader.readLine();
            Connection connection = MysqlConnection.createConnection();
            String Query = "UPDATE STUDENTS SET firstName = ?, lastName = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
            System.out.println("Updated Successfully 😄.");
            showStudents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Failed to update😓";
    }
}
