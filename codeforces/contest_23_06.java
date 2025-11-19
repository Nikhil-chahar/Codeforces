package codeforces;
import java.util.*;
public class contest_23_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            if (n == 1) {
                System.out.println(-1);
                continue;
            }

            int minOps = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int diff = Math.abs(a[i] - a[j]);
                    int len = j - i + 1;
                    int ops = len - 2;

                    int minVal = Math.min(a[i], a[j]);
                    int maxVal = Math.max(a[i], a[j]);

                    if (diff <= 1) {
                        minOps = Math.min(minOps, ops);
                    } else if (diff == len - 1) {
                        minOps = Math.min(minOps, ops);
                    } else if (diff == 0 && len == 2) {
                        minOps = Math.min(minOps, ops);
                    } else if (diff == 0 && len > 2 && (minVal == 1 || maxVal == 1)) {
                        minOps = Math.min(minOps, ops);
                    }
                    
                    
                    
                    if (diff == len - 1 && minVal == 1) {
                        minOps = Math.min(minOps, ops);
                    }

                    if (diff == 0) { 
                        if (len == 2) {
                             minOps = Math.min(minOps, ops);
                        } else {
                            if (minVal == 1) { 
                                 minOps = Math.min(minOps, ops);
                            }
                        }
                    } else if (Math.abs(a[i] - a[j]) <= 1) {
                         minOps = Math.min(minOps, ops);
                    } else if (Math.abs(a[i] - a[j]) == len - 1) {
                        minOps = Math.min(minOps, ops);
                    }
                }
            }

            if (minOps == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minOps);
            }
        }
        sc.close();
    }
}