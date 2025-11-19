package codeforces;
import java.util.*;
public class max_tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
            int[] in = new int[n + 1];

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                long x = sc.nextLong();
                long y = sc.nextLong();

                if (x >= y) {
                    g.get(u).add(v);
                    in[v]++;
                } else {
                    g.get(v).add(u);
                    in[u]++;
                }
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (in[i] == 0) q.add(i);
            }

            List<Integer> ord = new ArrayList<>(n);
            while (!q.isEmpty()) {
                int u = q.poll();
                ord.add(u);
                for (int w : g.get(u)) {
                    if (--in[w] == 0) q.add(w);
                }
            }

            int[] p = new int[n + 1];
            for (int i = 0; i < n; i++) {
                p[ord.get(i)] = n - i;
            }

            for (int i = 1; i <= n; i++) {
                if (i > 1) System.out.print(" ");
                System.out.print(p[i]);
            }
            System.out.println();
        }

        sc.close();
    }
}


