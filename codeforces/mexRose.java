package codeforces;
import java.io.*;
public class mexRose {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, Length = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= Length) {
                Length = in.read(buffer);
                ptr = 0;
                if (Length <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= 32) {
                if (c == -1) return Integer.MIN_VALUE;
            }
            int signature = 1;
            if (c == '-') {
                signature = -1;
                c = read();
            }
            int value = 0;
            while (c > 32) {
                value = value * 10 + (c - '0');
                c = read();
            }
            return value * signature;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner FS = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = FS.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = FS.nextInt();
            int k = FS.nextInt();
            int[] count1 = new int[n + 1]; 
            for (int i = 0; i < n; i++) {
                int v = FS.nextInt();
                if (v >= 0 && v <= n) count1[v]++;
            }

            if (k == n) {
                int misA = 0;
                for (int x = 0; x <= n - 1; x++) if (count1[x] == 0) misA++;
                sb.append(misA).append('\n');
            } else {
                int mis = 0;
                for (int x = 0; x <= k - 1; x++) if (count1[x] == 0) mis++;
                int countValK = count1[k];
                sb.append(Math.max(mis, countValK)).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
