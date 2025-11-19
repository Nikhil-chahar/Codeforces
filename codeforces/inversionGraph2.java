package codeforces;
import java.util.*;
public class inversionGraph2 {
    static final int MOD = 1000000007;

    static int addMod(int a, int b) {
        a += b;
        if (a >= MOD) a -= MOD;
        return a;
    }

    // Fenwick tree add
    public static void fenwAdd(int[] bit, int idx, int val, int size) {
        int i = idx + 1;
        while (i <= size) {
            bit[i] += val;
            if (bit[i] >= MOD) bit[i] -= MOD;
            i += i & -i;
        }
    }

    // Fenwick tree prefix sum
    public static int fenwSum(int[] bit, int idx) {
        if (idx < 0) return 0;
        int i = idx + 1;
        int res = 0;
        while (i > 0) {
            res += bit[i];
            if (res >= MOD) res -= MOD;
            i -= i & -i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            // Coordinate compression
            int[] vals = Arrays.copyOf(arr, n);
            Arrays.sort(vals);
            vals = Arrays.stream(vals).distinct().toArray();
            int m = vals.length;

            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.binarySearch(vals, arr[i]); // 0..m-1
            }

            int M = m;
            int SZ = M + 1;

            int[][] dp = new int[SZ][SZ];
            dp[0][0] = 1;

            int[][] colFenw = new int[SZ][SZ + 1];
            int[][] rowFenw = new int[SZ][SZ + 1];

            fenwAdd(colFenw[0], 0, 1, SZ);
            fenwAdd(rowFenw[0], 0, 1, SZ);

            for (int idx = 0; idx < n; idx++) {
                int v = arr[idx];
                int vIndex = v + 1;

                // Transition 1
                for (int lb = 0; lb <= M; lb++) {
                    int S1 = fenwSum(colFenw[lb], vIndex);
                    if (S1 != 0) {
                        dp[vIndex][lb] = addMod(dp[vIndex][lb], S1);
                        fenwAdd(colFenw[lb], vIndex, S1, SZ);
                        fenwAdd(rowFenw[vIndex], lb, S1, SZ);
                    }
                }

                // Transition 2
                for (int la = vIndex + 1; la <= M; la++) {
                    int S2 = fenwSum(rowFenw[la], vIndex);
                    if (S2 != 0) {
                        dp[la][vIndex] = addMod(dp[la][vIndex], S2);
                        fenwAdd(colFenw[vIndex], la, S2, SZ);
                        fenwAdd(rowFenw[la], vIndex, S2, SZ);
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i <= M; i++) {
                for (int j = 0; j <= M; j++) {
                    ans = addMod(ans, dp[i][j]);
                }
            }

            System.out.println(ans);
        }
    }

    // Overloaded fenwick helpers for 2D array rows
    public static void fenwAdd(int[] bit, int idx, int val, int size) {
        int i = idx + 1;
        while (i <= size) {
            bit[i] += val;
            if (bit[i] >= MOD) bit[i] -= MOD;
            i += i & -i;
        }
    }

    public static int fenwSum(int[] bit, int idx) {
        if (idx < 0) return 0;
        int i = idx + 1;
        int res = 0;
        while (i > 0) {
            res += bit[i];
            if (res >= MOD) res -= MOD;
            i -= i & -i;
        }
        return res;
    }
}


