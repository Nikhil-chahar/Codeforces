package codeforces;
import  java.util.*;
public class tram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int curr=0,mx=0;

        while(n-- >0){
            int out = sc.nextInt();
            int in = sc.nextInt();
            curr += (in-out);
            mx = Math.max(curr,mx);
        }
        System.out.println(mx);
    }
}
