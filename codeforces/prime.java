package codeforces;

import java.io.*;
import java.util.*;

public class prime {
    public static List<Long> goodNumbers = new ArrayList<>();
    public static final long LIMIT = (long) 1e18;

    public static void main(String[] args) throws IOException {
        generateGoodNumbers(1, 11);
        Collections.sort(goodNumbers);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long l = Long.parseLong(tokenizer.nextToken());
            long r = Long.parseLong(tokenizer.nextToken());
            int left = lowerBound(goodNumbers, l);
            int right = upperBound(goodNumbers, r);
            System.out.println(right - left);
        }
    }

    public static void generateGoodNumbers(long current, int index) {
        if (current > LIMIT) return;
        if (index > 100) return;

        if (current > 1) goodNumbers.add(current);

        for (int i = index; i <= 100; i++) {
            if (isPrime(i) && i >= 10) {
                if (current > LIMIT / i) continue;
                generateGoodNumbers(current * i, i);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }

    public static int lowerBound(List<Long> list, long val) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < val) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static int upperBound(List<Long> list, long val) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= val) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
