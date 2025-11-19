package codeforces;
import java.util.*;
public class ques1 {
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);
        int t = nm.nextInt();
        int c=0;
        while(t-- !=0){
            String s = nm.next();
            if(s.charAt(1) == '+'){
                c++;
            }else{
                c--;
            }
        }
        System.out.println(c);
    }
}
