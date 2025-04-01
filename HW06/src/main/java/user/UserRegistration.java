package user;

import java.util.logging.Level;
import java.util.logging.Logger;

class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}


class RegisterException extends RuntimeException {
    public RegisterException(String message, Throwable e) {
        super(message, e);
    }
}

public class UserRegistration {
    private static final Logger logger = Logger.getLogger(UserRegistration.class.getName());


    static private void validateName(String name) {
        if (name == null) {
            logger.log(Level.WARNING, "InvalidName: Name must not be null");
            throw new InvalidNameException("Name must not be null");
        } else if (name.length() < 3) {
            logger.log(Level.WARNING, "InvalidName: Name length must not be less than 3");
            throw new InvalidNameException("Name length must not be less than 3");
        }
    }

    static private void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            logger.log(Level.WARNING, "InvalidAge: Age must not be less than 18");
            throw new InvalidAgeException("Age must not be less than 18");
        }
    }

    public User registerUser(String name, int age) {
        try {
            validateName(name);
            validateAge(age);
            User newUser = new User(name, age);
            logger.log(Level.INFO, "registerUser success: " + newUser);
            System.out.println("registerUser success: " + newUser);
            return newUser;
        } catch (InvalidNameException e) {
            System.out.println("InvalidName: " + e.getMessage());
            logger.log(Level.SEVERE, "registerUser failed: Invalid parameters", e);
            throw new RegisterException("Invalid parameters", e);
        } catch (InvalidAgeException e) {
            System.out.println("InvalidAge: " + e.getMessage());
            logger.log(Level.SEVERE, "registerUser failed: Invalid parameters", e);
            throw new RegisterException("Invalid parameters", e);
        }
    }
}