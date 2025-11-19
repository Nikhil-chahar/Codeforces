package codeforces;
import java.util.*;
public class Devyatkino {
    // Function to check if a number contains the digit 7
    static boolean containsSeven(int num) {
        while (num > 0) {
            if (num % 10 == 7) return true;
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt();
            int operations = 0;

            while (!containsSeven(n)) {
                n += 9;
                operations++;
            }
            System.out.println(operations);
        }
        scanner.close();
    }
}

