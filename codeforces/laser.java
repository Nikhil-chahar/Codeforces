package codeforces;

import java.util.*;
public class laser {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int t =sca.nextInt();
        while (t-- > 0) {
            int n =sca.nextInt();
            int m =sca.nextInt();
            int x =sca.nextInt();
            int y =sca.nextInt();
            int horCross = 0;
            for (int i = 0; i < n; i++) {
                int a =sca.nextInt();
                if (a < y) {
                    horCross++;
                }
            }
            int verCross = 0;
            for (int i = 0; i < m; i++) {
                int b = sca.nextInt();
                if (b < x) {
                    verCross++;
                }
            }
            System.out.println(horCross + verCross);
        }
    }
}

