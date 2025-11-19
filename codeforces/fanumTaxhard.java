package codeforces;
import java.util.*;

public class fanumTaxhard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Size of array a
            int m = scanner.nextInt(); // Size of array b
            int[] a = new int[n];
            int[] b = new int[m];

            // Read array a
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            // Read array b
            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
            }

            // Sort array b for efficient searching
            Arrays.sort(b);

            // Check if it's possible to sort a in non-decreasing order
            boolean possible = true;
            int prev = Integer.MIN_VALUE; // Initialize previous value to the smallest possible

            for (int i = 0; i < n; i++) {
                // Option 1: Do not perform the operation
                int option1 = a[i];

                // Option 2: Perform the operation with the best b[j]
                // Find the smallest b[j] such that b[j] - a[i] >= prev
                int target = prev + a[i];
                int idx = Arrays.binarySearch(b, target);

                if (idx < 0) {
                    idx = -idx - 1; // Insertion point
                }

                int option2 = (idx < m) ? b[idx] - a[i] : Integer.MAX_VALUE;

                // Choose the option that is >= previous and as small as possible
                if (option1 >= prev && option2 >= prev) {
                    prev = Math.min(option1, option2);
                } else if (option1 >= prev) {
                    prev = option1;
                } else if (option2 >= prev) {
                    prev = option2;
                } else {
                    // Neither option is valid
                    possible = false;
                    break;
                }
            }

            // Output the result for this test case
            if (possible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}