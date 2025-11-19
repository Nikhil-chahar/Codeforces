package codeforces;

import java.io.*;
public class distinctElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] b = new long[n + 1];  // 1-based indexing
            String[] parts = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                b[i] = Long.parseLong(parts[i - 1]);
            }

            int[] a = new int[n + 1];
            int nextLabel = 1;
            long prevB = 0;

            for (int i = 1; i <= n; i++) {
                long d = b[i] - prevB;
                int prevIdx = (int)(i - d);

                if (prevIdx > 0) {
                    a[i] = a[prevIdx];
                } else {
                    a[i] = nextLabel;
                    nextLabel++;
                }

                prevB = b[i];
            }

            for (int i = 1; i <= n; i++) {
                out.append(a[i]).append(" ");
            }
            out.append("\n");
        }

        System.out.print(out);
    }
}
