package codeforces;
import java.util.*;

public class NiceCircularArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = scanner.nextLong();

            System.out.println(minOperations(arr, n));
        }

        scanner.close();
    }

    private static long minOperations(long[] arr, int n) {
        boolean alreadyNice = true;
        for (int i = 0; i < n; i++) {
            int prev = (i - 1 + n) % n, next = (i + 1) % n;
            if (arr[i] != arr[prev] && arr[i] != arr[next]) {
                alreadyNice = false;
                break;
            }
        }
        if (alreadyNice) return 0;

        boolean[] bad = new boolean[n];
        for (int i = 0; i < n; i++) {
            int prev = (i - 1 + n) % n, next = (i + 1) % n;
            bad[i] = (arr[i] != arr[prev] && arr[i] != arr[next]);
        }

        boolean[] visited = new boolean[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || !bad[i]) continue;
            List<Integer> indices = new ArrayList<>();
            int j = i;
            while (!visited[j] && bad[j]) {
                visited[j] = true;
                indices.add(j);
                j = (j + 1) % n;
            }
            int len = indices.size();
            if (len == 1) {
                int idx = indices.get(0);
                int prev = (idx - 1 + n) % n, next = (idx + 1) % n;
                total += Math.min(Math.abs(arr[idx] - arr[prev]), Math.abs(arr[idx] - arr[next]));
            } else {
                long[] dp = new long[len + 1];
                long INF = Long.MAX_VALUE / 4;
                Arrays.fill(dp, INF);
                dp[0] = 0;
                for (int k = 2; k <= len; k++) {
                    int i1 = indices.get(k - 2);
                    int i2 = indices.get(k - 1);
                    dp[k] = Math.min(dp[k], dp[k - 2] + Math.abs(arr[i1] - arr[i2]));
                }
                total += dp[len];
            }
        }
        return total;
    }
}

