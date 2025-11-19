package codeforces;
import java.util.*;
public class rizz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        
        int t = sc.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of 0's
            int m = sc.nextInt(); // Number of 1's
            int k = sc.nextInt(); // Maximum balance-value
            
            if (Math.abs(n - m) > k) {
                output.append("-1\n");
                continue;
            }
            
            StringBuilder result = new StringBuilder();
            
            while (n > 0 || m > 0) {
                if (n > m) {
                    result.append("0");
                    n--;
                } else {
                    result.append("1");
                    m--;
                }
            }
            
            output.append(result.toString()).append("\n");
        }
        
        System.out.print(output);
        sc.close();
    }
}