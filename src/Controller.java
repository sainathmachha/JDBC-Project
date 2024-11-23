import java.util.Scanner;

public class Controller {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		if (flag) {
			try {
				StudentsService.Execute();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Enter 1 to continue");
			int choice = sc.nextInt();
			if (choice == 1) {
				flag = true;
				StudentsService.Execute();
			}
			else {
				flag = false;
				System.out.println("Thanks for Using the Application.");
			}
		}
	}
}