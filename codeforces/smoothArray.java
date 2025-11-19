package codeforces;

import java.io.*;
import java.util.*;
public class smoothArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] arr1 = new long[n + 1];
            long[] arr2 = new long[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) arr1[i] = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) arr2[i] = Long.parseLong(st.nextToken());
            long tl = 0;
            for (int i = 1; i <= n; i++) tl += arr2[i];
            long[] dp = new long[n + 1];
            long max = 0;
            for (int i = 1; i <= n; i++) {
                dp[i] = arr2[i];
                for (int j = 1; j < i; j++) {
                    if (arr1[j] <= arr1[i]) dp[i] = Math.max(dp[i], dp[j] + arr2[i]);
                }
                max = Math.max(max, dp[i]);
            }
            sb.append(tl - max).append('\n');
        }
        System.out.print(sb);
    }
}
