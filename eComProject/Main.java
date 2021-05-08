import java.util.Scanner;

import business.abstracts.AuthService;
import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.concretes.GoogleManagerAdapter;
import core.concretes.VerificationLink;
import dataAccess.concretes.InMemoryUserDao;

public class Main {

	private static boolean flag = true;
	private static Scanner in = new Scanner(System.in);
	static AuthService authService = new AuthManager( new UserManager(new InMemoryUserDao()), new GoogleManagerAdapter(), new VerificationLink());
	
	public static void main(String[] args) {
		
		dashboard();
		
	
	}
	
	public static void dashboard() {
		
		while (flag)
        {
            System.out.println("\n   Main Menu ");
            System.out.println("1. User Register");
            System.out.println("2. User Register With Google");
            System.out.println("3. User Login");
            System.out.println("4. Exit \n");
            
            int key = in.nextInt();
            switch (key)
            {
                case 1:
                    Register();
                    break;
                case 2:
                    RegisterGoogleAccount();
                    break;
                case 3:
                    Login();
                    break;
                case 4:
                	System.out.println("Safe Exit!");
                    flag = false;
                    break;
                default:
                	System.out.println("\nYou entered an incorrect value! Please try again.");
                    break;
            }
        }
		
	}
	
	private static void Register() {
		
		System.out.println("First Name: ");
		String firstName = in.next();
		
		System.out.println("Last Name: ");
		String lastName = in.next();
		
		System.out.println("Email Address: ");
		String email = in.next();
		
		System.out.println("Password: ");
		String password = in.next();
		
		authService.register(firstName, lastName, email, password);
		
	}
	
	private static void RegisterGoogleAccount() {
		
		System.out.println("Email Address: ");
		String email = in.next().toString();
		
		System.out.println("Password: ");
		String password = in.next().toString();
		
		authService.registerGoogle(email, password);
	}
	
	private static void Login() {
		
		System.out.println("Email Address: ");
		String email = in.next();
		
		System.out.println("Password: ");
		String password = in.next();
		
		authService.login(email, password);
	}
}
