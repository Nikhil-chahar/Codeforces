package codeforces;
import java.util.*;
public class Next_Round {
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);
        int t = nm.nextInt();
        int val = nm.nextInt();

        int c=0;
        while(t-- !=0){
            int a = nm.nextInt();
            if(a>val){
                c++;
            }
        }
        System.out.println(c);
    }
}
