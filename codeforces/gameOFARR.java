package codeforces;

import java.util.*;
import java.io.*;
public class gameOFARR {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        StringBuilder out = new StringBuilder();
        int t = sc.nextInt();
       for (int i=0;i<t;i++) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for(int j = 0; j < n; j++) {
                a[j] = sc.nextLong();
            }

            HashMap<Long, Integer> freq = new HashMap<>();
            for (long v : a) {
                freq.put(v, freq.getOrDefault(v, 0) + 1);
            }

            long[] tokens = new long[n + 1];
            for (Map.Entry<Long, Integer> entry : freq.entrySet()) {
                long val = entry.getKey();
                int cnt = entry.getValue();
                tokens[cnt] += val;
            }

            long alice = 0, bob = 0;
            long pos = 0;

            for (int w = n; w >= 1; w--) {
                long k = tokens[w];
                if (k == 0) continue;
                int p = (int)(pos % 2);
                long takeAlice = (k + (1 - p)) / 2;
                long takeBob = k - takeAlice;
                alice += takeAlice * w;
                bob += takeBob * w;
                pos += k;
            }

            out.append(alice).append(" ").append(bob).append("\n");
        }
        System.out.print(out);
    }

   
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}
