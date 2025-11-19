package codeforces;
import java.util.Scanner;
import java.util.StringJoiner;

public class submission{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt();
        
        while (test-- > 0) {
            int n = sc.nextInt();
            long s = sc.nextLong();
            
            long sum = 0;
            int count0 = 0;
            int count1 = 0;
            int count2 = 0;
            
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                sum += a;
                if(a == 0){
                    count0++;
                } else if (a == 1) {
                    count1++;
                } else if (a == 2) {
                    count2++;
                }
            }
            
            long T = s - sum;
            
            if (T < 0 || T == 1) {
                StringJoiner str = new StringJoiner(" ");
                
                for (int i = 0; i < count0; i++) {
                    str.add("0");
                }
                for (int i = 0; i < count2; i++) {
                    str.add("2");
                }
                for (int i = 0; i < count1; i++) {
                    str.add("1");
                }
                
                System.out.println(str.toString());
            } else {
                System.out.println(-1);
            }
        }
    }
}
