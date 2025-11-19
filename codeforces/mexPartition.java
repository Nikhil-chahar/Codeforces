package codeforces;

import java.util.*;

public class mexPartition {
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);
        int test = nm.nextInt();

        while (test-- > 0) {
            int n = nm.nextInt();
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                int a = nm.nextInt();
                set.add(a);
            }

            int mex = 0;
            boolean found = false;

            while (true) {
                if (!set.contains(mex)) {
                    found = true;
                    System.out.println(mex);
                    break;
                }
                mex++;
            }

            if (!found) {
                System.out.println(mex);
            }
        }
    }
}
