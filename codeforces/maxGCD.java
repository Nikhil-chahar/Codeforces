package codeforces;
import java.util.*;
public class maxGCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int len = sc.nextInt();
            int rc = sc.nextInt();

            int[] freq = new int[len + 1];
            for (int i = 0; i < len; i++) {
                int value = sc.nextInt();
                freq[value]++;
            }

            int[] preSum = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                preSum[i] = preSum[i - 1] + freq[i];
            }

            java.util.function.IntUnaryOperator countGreaterOrEqual = value -> {
                if (value > len) return 0;
                if (value <= 1) return preSum[len];
                return preSum[len] - preSum[value - 1];
            };

            int ele = len - rc;
            int div = 1;

            for (int d = len; d >= 1; d--) {
                long good = countGreaterOrEqual.applyAsInt(4 * d);

                if (d <= len) good += freq[d];
                if (2 * d <= len) good += freq[2 * d];
                if (3 * d <= len) good += freq[3 * d];

                if (good >= ele) {
                    div = d;
                    break;
                }
            }

            System.out.println(div);
        }
    }
}
