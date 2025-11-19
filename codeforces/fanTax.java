package codeforces;

import java.util.Scanner;
public class fanTax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 

        while (t-- > 0) {
            int n = scanner.nextInt(); 
            int m = scanner.nextInt(); 
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
            }
            int bValue = b[0];
            boolean possible = true;
            int prev = Integer.MIN_VALUE; 
            for (int i = 0; i < n; i++) {
                int option1 = a[i];
                int option2 = bValue - a[i];
                if (option1 >= prev && option2 >= prev) {
                    prev = Math.min(option1, option2);
                } else if (option1 >= prev) {
                    prev = option1;
                } else if (option2 >= prev) {
                    prev = option2;
                } else {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
