package codeforces;
import java.util.*;
class BePositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int zeros = 0, neg = 0, ops = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] == 0) {
                    zeros++;
                 } else if (arr[i] == -1) {
                    neg++;
                }
            }
            ops += zeros; // Each zero needs one operation to become 1
            if(neg % 2 != 0) {
                ops += 2; // Need two operations to fix the odd negative count
            }
            
            System.out.println(ops);
        }
    }
}
