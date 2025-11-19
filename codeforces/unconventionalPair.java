package codeforces;
import java.util.*;
public class unconventionalPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            Arrays.sort(arr);
            
            int ans = 0;
            for(int i=0;i<n;i++){
                if(i%2==0){
                    ans = Math.max(ans, Math.abs(arr[i]-arr[i+1]));
                }
            }
            
            System.out.println(ans);
        }
    }
}

