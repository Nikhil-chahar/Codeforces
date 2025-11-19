package codeforces;
import java.util.*;
public class nearlyLuckyNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cnt=0;
        for(char ch : s.toCharArray()){
            if(ch == '4' || ch == '7') cnt++;
        }
        if(cnt == 4 || cnt == 7){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        
    }
}

