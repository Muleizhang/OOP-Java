package user;

import java.util.ArrayList;
import java.util.List;

public class App {
    public List<User> users = new ArrayList<>();

    private final UserRegistration registration = new UserRegistration();

    public void startRegistration(String name, int age) {
        users.add(registration.registerUser(name, age));
    }

    public static void main(String[] args) {
        App app = new App();
        try {
            app.startRegistration("Mulei", 20);
        } catch (RegisterException e) {
            System.out.println("startRegistration failed: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());
        }
        System.out.println();
        try {
            app.startRegistration("", 20);
        } catch (RegisterException e) {
            System.out.println("startRegistration failed: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());
        }
        System.out.println();
        try {
            app.startRegistration(null, 20);
        } catch (RegisterException e) {
            System.out.println("startRegistration failed: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());
        }
        System.out.println();
        try {
            app.startRegistration("Mulei", 2);
        } catch (RegisterException e) {
            System.out.println("startRegistration failed: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());
        }
    }
}
