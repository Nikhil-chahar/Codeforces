package codeforces;
import java.util.*;

public class roundTrip{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- >0){
            long rat = sc.nextLong(); 
            long Limit = sc.nextLong();  
            long inc = sc.nextLong();  
            int n = sc.nextInt();    
            String str = sc.next();    

            long Le = rat;
            long Ri = rat;
            int ans = 0;

            for (int i=0;i<n;i++) {
                char ch = str.charAt(i);
                if (ch == '1') {
                    ans++;
                    Le = Math.max(0, Le - inc);
                    Ri = Ri + inc;
                } else {
                    if (Le < Limit) {
                        ans++;
                        long newL = Math.max(0, Le - inc);
                        long newR = Ri + inc;
                        newR = Math.min(newR, Limit - 1 + inc);
                        Le = newL;
                        Ri = newR;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}