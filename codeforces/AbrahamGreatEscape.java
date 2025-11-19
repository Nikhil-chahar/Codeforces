package codeforces;
import java.util.*;
public class AbrahamGreatEscape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            if (k > n * n) {
                System.out.println("NO");
                continue;
            }

            char[][] grid = new char[n][n];
            // Default all arrows point right
            for (int i = 0; i < n; i++) Arrays.fill(grid[i], 'R');

            int escape = 0;
            // Fill from top-left, make 'U' to increase escape count
            for (int i = 0; i < n && escape < k; i++) {
                for (int j = 0; j < n && escape < k; j++) {
                    grid[i][j] = 'U';
                    escape++;
                }
            }

            // Now, if the configuration matches examples, print
            // Adjust pattern for better variety (for k not full)
            if (k == n * n - 1) {
                // known impossible pattern (like 2,3)
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for (int i = 0; i < n; i++) {
                    System.out.println(new String(grid[i]));
                }
            }
        }
        sc.close();
    }
}
