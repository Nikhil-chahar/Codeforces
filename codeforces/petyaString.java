package codeforces;
import java.util.*;

public class petyaString{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if(s1.equals(s2)){
            System.out.println(0);
        }else if(s1.compareTo(s2) == 1){
            System.out.println(1);
        }else{
            System.out.println(-1);
        }
    }
}