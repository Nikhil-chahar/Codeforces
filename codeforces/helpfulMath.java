package codeforces;
import java.util.*;

public class helpfulMath{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int one = 0;
        int tw = 0;
        int th = 0;

        for(char ch  : s.toCharArray()){
            if(ch == '1') one++;
            else if(ch == '2') tw++;
            else if(ch == '3') th++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<one;i++){
            sb.append("1+");
        }
        for(int i = 0;i<tw;i++){
            sb.append("2+");
        }
        for(int i = 0;i<th;i++){
            sb.append("3+");
        }
        System.out.println(sb.toString().substring(0,sb.length()-1));

    }
}