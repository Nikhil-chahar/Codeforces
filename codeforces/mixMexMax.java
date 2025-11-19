package codeforces;

import java.util.*;
public class mixMexMax {
    // Function to calculate MEX of 3 numbers
    static int mex(int a, int b, int c) {
        boolean[] present = new boolean[5];  // safe till value 4
        present[a] = true;
        present[b] = true;
        present[c] = true;
        for (int i = 0; i <= 4; i++) {
            if (!present[i]) return i;
        }
        return 5;
    }

    // Check if the array is good
    static boolean isGood(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int a = arr[i], b = arr[i + 1], c = arr[i + 2];
            int maxVal = Math.max(a, Math.max(b, c));
            int minVal = Math.min(a, Math.min(b, c));
            int mexVal = mex(a, b, c);
            if (mexVal != maxVal - minVal) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] original = new int[n];

            for (int i = 0; i < n; i++) {
                original[i] = sc.nextInt();
            }

            boolean found = false;

            // Try replacing -1 with only one fixed value at a time (0 to 3)
            for (int x = 0; x <= 3; x++) {
                int[] modified = new int[n];
                for (int i = 0; i < n; i++) {
                    modified[i] = (original[i] == -1 ? x : original[i]);
                }

                if (isGood(modified)) {
                    found = true;
                    break;
                }
            }

            System.out.println(found ? "YES" : "NO");
        }

        sc.close();
    }
}

