package codeforces;
import java.util.*;
public class increment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] fav = new int[m];
            for (int i = 0; i < m; i++) fav[i] = sc.nextInt();

            int count = solve(n, fav);
            System.out.println(count);
        }
    }

    private static int solve(int n, int[] fav) {
        int m = fav.length;
        int count = 0;

        // Try placing fav[] starting in each block
        for (int startBlock = 1; startBlock <= n; startBlock++) {
            int posInBlock = 1; // start at first position inside block
            int idx = 0;
            int block = startBlock;

            while (idx < m && block <= n) {
                if (fav[idx] != posInBlock) break; // mismatch
                idx++;
                posInBlock++;
                if (posInBlock > block) { // move to next block
                    block++;
                    posInBlock = 1;
                }
            }
            if (idx == m) count++;
        }

        return count;
    }
}
