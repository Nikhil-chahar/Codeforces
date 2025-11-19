package codeforces;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        while(n > 0){
            int l=sc.nextInt();
            int r=sc.nextInt();
            int d=sc.nextInt();
            int u=sc.nextInt();
            if(l==r && l==u && d==u){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            n--;
        }
    }
}
