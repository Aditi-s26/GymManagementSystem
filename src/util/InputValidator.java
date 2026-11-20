
package util;

public class InputValidator {

    // Validate member or trainer name
    public static boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z ]+");
    }

    // Validate 10-digit phone number
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("[0-9]{10}");
    }

    // Validate positive integer
    public static boolean isPositiveInteger(int number) {
        return number > 0;
    }

    // Validate menu choice within a given range
    public static boolean isValidMenuChoice(int choice, int min, int max) {
        return choice >= min && choice <= max;
    }
}
