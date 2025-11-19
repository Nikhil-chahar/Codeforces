package codeforces;
import java.util.*;
public class reverseXor {
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);
        int test = nm.nextInt();

        while (test-- > 0) {
            int n = nm.nextInt();
            if (n == 0) {
                System.out.println("YES");
                continue;
            }
            int stZero = Integer.numberOfTrailingZeros(n);
            boolean valid = false;

            for (int shift = 0; shift <= stZero && !valid; shift++) {
                int shifted = n >> shift;
                int len = bitL(shifted);

                if (!isPalin(shifted)) continue;
                if (len % 2 == 1 && ((shifted >> (len / 2)) & 1) == 1) continue;

                valid = true;
            }
            if(valid){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static int bitL(int x) {
        if (x == 0) return 0;
        return 32 - Integer.numberOfLeadingZeros(x);
    }

    public static boolean isPalin(int x) {
        int len = bitL(x);
        for (int i = 0; i < len / 2; i++) {
            int le = (x >> i) & 1;
            int ri = (x >> (len - 1 - i)) & 1;
            if (le != ri) return false;
        }
        return true;
    }
}

