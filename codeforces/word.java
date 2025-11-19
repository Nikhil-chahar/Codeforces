package codeforces;
import java.util.*;
public class word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int big =0;
        for(char ch : s.toCharArray()){
            if((int)ch >=65  && (int)ch <=90){
                big++;
            }
        }
        if((big > s.length()/2) || (s.length()%2 ==0 && big== s.length())){
            System.out.println(s.toUpperCase());
        }else{
            System.out.println(s.toLowerCase());
        }
        
    }
}
