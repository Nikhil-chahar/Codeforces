package codeforces;

import java.util.*;
public class date29_3_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        for (int testCase = 0; testCase < t; testCase++) {
            int n = sc.nextInt(); 
            int[] beautyLevels = new int[n];
            
            for (int i = 0; i < n; i++) {
                beautyLevels[i] = sc.nextInt();
            }
            
            int maxPleasure = findMaximumPleasure(n, beautyLevels);
            System.out.println(maxPleasure);
        }
    }
    public static int findMaximumPleasure(int n, int[] beautyLevels) {
        int maxPleasure = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = beautyLevels[i];
                int b = beautyLevels[j];if (a == b) {
                    maxPleasure = Math.max(maxPleasure, a);
                    continue;
                }
                int diff = Math.abs(a - b);
                
               for (int g = 1; g * g <= diff; g++) {
                    if (diff % g == 0) {
                        int d = (g - (a % g)) % g;
                        int gcdValue = gcd(a + d, b + d);
                        maxPleasure = Math.max(maxPleasure, gcdValue);
                        
                        int g2 = diff / g;
                        d = (g2 - (a % g2)) % g2;
                        gcdValue = gcd(a + d, b + d);
                        maxPleasure = Math.max(maxPleasure, gcdValue);
                    }
                }
            }
        }
        return maxPleasure;
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
