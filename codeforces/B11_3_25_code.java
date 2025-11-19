package codeforces;

import java.util.Scanner;

public class B11_3_25_code {
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);
        int n = nm.nextInt();
        while(n > 0){
            int l = nm.nextInt();
            int r = nm.nextInt();
            int d = nm.nextInt();
            int u = nm.nextInt();
            if(l==r && l==u && d==u){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            n--;
        }
    }
}
