package codeforces;
import java.util.*;
public class vanyaAndFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lim = sc.nextInt();
        int arr[] = new int[n];
        int ans=0;

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            if(arr[i] > lim){
                ans +=2;
            }else{
                ans++;
            }
        }
        System.out.println(ans);

    }
}
