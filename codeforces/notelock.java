package codeforces;
import java.util.*;

public class notelock {
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);
        int test = nm.nextInt(); // number of test cases

        while (test-- > 0) {
            int n = nm.nextInt(); // length of string
            int k = nm.nextInt(); // window size
            String s = nm.next(); // binary string

            int i = 0;
            int c = 0;

            while (i < n) {
                if (s.charAt(i) == '1') {
                    boolean changed = true;
                    for (int j = Math.max(0, i - k + 1); j < i; j++) {
                        if (s.charAt(j) == '1') {
                            changed = false;
                            break;
                        }
                    }
                    if (changed) {
                        c++;
                        i += k;   
                        continue;
                    }
                }
                i++;
            }
            System.out.println(c);
        }
    }
}
