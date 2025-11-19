package codeforces;
import java.util.*;

public class add_or_xor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long k = sc.nextLong();

            long answer = -1;
            for (long x = l; x <= r && x - l < 1000; x++) {
                long totalXor = 0;
                long totalAnd = x;
                for (int i = 1; i < n; i++) {
                    totalXor ^= x;
                    totalAnd &= x;
                }
                totalXor ^= x;
                totalAnd &= x;

                if ((totalAnd ^ totalXor) == k) {
                    answer = x;
                    break;
                }
            }

            System.out.println(answer);
        }
    }
}
