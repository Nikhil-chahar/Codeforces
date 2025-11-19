package codeforces;
import java.util.*;
public class skibi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String s = sc.next();
            String sub1 = s.substring(0,s.length()-2);
            String sub2 = s.substring(s.length()-2);
            if(sub2.equals("us")){
                sub1+="i";
            }else{
                sub1+=sub2;
            }
            System.out.println(sub1);
        }
    }
}
