
import java.util.HashMap;
import java.util.Scanner;

// User Authentication System
// Concepts: HashMap, String methods, Exception handling, File (optional)
// Requirements: Register, login, and reset password system using username-password map.
// Filename: UserAuthApp.java
public class UserAuthApp {

    private HashMap<String, String> userDB = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    boolean isLoggedIn = false;
    String loggedUser = null;

    public static void main(String[] args) {
        System.out.println("Welcome to User Auth");
        UserAuthApp app = new UserAuthApp();
        while (true) {
            System.out.println("Please choose an option:\n1 : Register\n2 : Login\n3 : Change Password\n4 : Logout\n5 : Close");
            int choice = app.sc.nextInt();
            switch (choice) {
                case 1:
                    app.Register();
                    break;
                case 2:
                    app.Login();
                    break;
                case 3:
                    app.changePassword();
                    break;
                case 4:
                    app.logOut();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void Register() {
        System.out.println("Enter Username : ");
        String userName = sc.next();
        if (userDB.containsKey(userName)) {
            System.out.println("User already exist! Please login.");
        } else {
            System.out.println("Enter Password : ");
            String password = sc.next();
            userDB.put(userName, password);
            System.out.println("User created sucessfuly.");
            loggedUser = userName;
            isLoggedIn = true;
        }
    }

    public void Login() {
        System.out.println("Enter Username : ");
        String userName = sc.next();
        if (userDB.containsKey(userName)) {
            int attempts = 3;
            String password;
            while (attempts > 0) {
                System.out.println("Enter Password : ");
                password = sc.next();
                String p1 = userDB.get(userName);
                if (p1.equals(password)) {
                    loggedUser = userName;
                    isLoggedIn = true;
                    System.out.println("Sucessfully Logged In.");
                    break;
                } else {
                    System.out.println(password);
                    System.out.println(userDB.get(userName));
                    System.out.println("Attempt Failed! Please try again.");
                    attempts -= 1;
                }
            }
        } else {
            System.out.println("User not present.");
        }
    }

    private void changePassword() {
        if (isLoggedIn) {
            String password;
            System.out.println("Enter New Password : ");
            password = sc.next();
            userDB.replace(loggedUser, password);
            System.out.println("Password changed.");
        } else {
            System.out.println("Please first login.");
        }
    }

    private void logOut() {
        if (isLoggedIn) {
            isLoggedIn = false;
            loggedUser = null;
        } else {
            System.out.println("Your are already logged out.");
        }
    }

}
