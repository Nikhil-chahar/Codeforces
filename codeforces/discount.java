package codeforces;
import java.util.*;
public class discount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int num = sc.nextInt();
            int k = sc.nextInt();
            
            Long[] arr = new Long[num];  // Use Long for descending sort
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextLong();
            }
            
            int[] brr = new int[k];
            for (int i = 0; i < k; i++) {
                brr[i] = sc.nextInt();
            }
            
            // Sort a in descending order
            Arrays.sort(arr, Collections.reverseOrder());
            
            // Sort b in ascending order
            Arrays.sort(brr);
            
            long answer = 0;
            for (long x : arr) answer += x;
            
            int i = 0;
            for (int x : brr) {
                if (i + x - 1 >= num) break;
                i += x - 1;
                answer -= arr[i];
                ++i;
            }
            System.out.println(answer);
        }
    }
}
