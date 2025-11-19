package codeforces;

import java.util.Scanner;

public class bit {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        int c=0;

        while(t-- >0){
            String s = sc.next();
            if(s.charAt(1) == '-'){
                c--;
            }else{
                c++;
            }
        }
        System.out.println(c);
        
    }
}
