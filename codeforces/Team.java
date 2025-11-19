package codeforces;
import java.util.*;
public class Team {
    public static void main(String[] args) {
        Scanner nm =  new Scanner(System.in);
        int t = nm.nextInt();
        int count=0;
        while(t-- >0){
            int a = nm.nextInt();
            int b = nm.nextInt();
            int c = nm.nextInt();

            if((a==1 && b==1) || (a==1 && c==1) || (c==1 && b==1) ){
                count++;
            }
        }
        System.out.println(count);

    }
}
