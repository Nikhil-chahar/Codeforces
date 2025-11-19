package codeforces;

import java.util.*;
public class adjacentDigitSum {
    // Function to calculate the sum of digits of a number
    static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            boolean found = false;

            for (int n = 1; n <= 1000000; n++) { // A large upper bound to check
                if (sumOfDigits(n) == x && sumOfDigits(n + 1) == y) {
                    found = true;
                    break;
                }
            }

            System.out.println(found ? "Yes" : "No");
        }
        scanner.close();
    }
}
