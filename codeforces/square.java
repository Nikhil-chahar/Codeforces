package codeforces;

import java.util.*;

public class square{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test-- >0){
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            int f3 = sc.nextInt();
            int f4 = sc.nextInt();

            if(f1 == f2 && f2 ==f3  && f3==f4){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}