package clinicreservation_main;
import java.util.InputMismatchException;
import java.util.Scanner;

public class scanner {
    public static final Scanner sc = new Scanner(System.in);
    private scanner() {}
    public static void close() {
        sc.close();
    }
    
    public static int nextInt() {
        int value = 0;
        boolean active;
        do {
            try {
                value = sc.nextInt();
                scanner.nextLine();
                active = false;
            }
            catch (InputMismatchException e) {
                System.out.print("Input is not an integer. Please try again: ");
                scanner.nextLine();
                active = true;
            }
        } while (active);
        return value;
    }
    
    public static String nextLine() {
        return sc.nextLine();
    }
    
    public static String next() {
        String value = sc.next();
        sc.nextLine();
        return value;
    }
}
