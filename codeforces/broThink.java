package codeforces;

import java.util.*;
public class broThink {
    static final int MOD = 998244353;
    static int[] powerOfTwo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        precomputePowers(200000);
        
        StringBuilder output = new StringBuilder();
        while (t-- > 0) {
            String s = sc.next();
            int q = sc.nextInt();
            int[] queries = new int[q];
            for (int i = 0; i < q; i++) {
                queries[i] = sc.nextInt() - 1; // Convert to 0-based index
            }

            output.append(solve(s, q, queries)).append("\n");
        }
        System.out.print(output);
        sc.close();
    }

    static void precomputePowers(int n) {
        powerOfTwo = new int[n + 1];
        powerOfTwo[0] = 1;
        for (int i = 1; i <= n; i++) {
            powerOfTwo[i] = (2 * powerOfTwo[i - 1]) % MOD;
        }
    }

    static long solve(String s, int q, int[] queries) {
        int n = s.length();
        char[] arr = s.toCharArray();
        long totalSum = calculateTotalF(arr);
        
        StringBuilder result = new StringBuilder();
        for (int idx : queries) {
            totalSum = updateTotalF(arr, idx, totalSum);
            result.append(totalSum).append(" ");
        }
        return Long.parseLong(result.toString().trim());
    }

    static long calculateTotalF(char[] arr) {
        int n = arr.length;
        int segmentCount = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                segmentCount++;
            }
        }
        return (long) segmentCount * powerOfTwo[n - 1] % MOD;
    }

    static long updateTotalF(char[] arr, int idx, long totalSum) {
        int n = arr.length;
        char prev = arr[idx];
        arr[idx] = (arr[idx] == '0') ? '1' : '0';
        
        int change = 0;
        if (idx > 0 && arr[idx] != arr[idx - 1]) change++;
        else if (idx > 0 && arr[idx] == arr[idx - 1]) change--;
        
        if (idx < n - 1 && arr[idx] != arr[idx + 1]) change++;
        else if (idx < n - 1 && arr[idx] == arr[idx + 1]) change--;
        
        totalSum = (totalSum + change * powerOfTwo[n - 1] % MOD + MOD) % MOD;
        return totalSum;
    }
}

