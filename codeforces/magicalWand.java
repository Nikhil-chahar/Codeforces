package codeforces;

import java.util.*;
public class magicalWand {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            boolean hasOdd = false, hasEven = false;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if ((a[i] & 1) == 0) hasEven = true;
                else hasOdd = true;
            }
            if (hasEven && hasOdd) Arrays.sort(a);
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(' ');
                sb.append(a[i]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
