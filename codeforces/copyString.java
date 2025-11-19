package codeforces;
import java.util.*;

public class copyString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int n = sc.nextInt();
            int maxSteps = sc.nextInt();
            String s = sc.next();
            String t = sc.next();

            if (s.equals(t)) {
                System.out.println(0);
                continue;
            }

            int steps = 0;
            String current = s;
            boolean possible = false;

            // Simulate up to k transformations
            while (steps < maxSteps) {
                StringBuilder next = new StringBuilder();
                next.append(current.charAt(0));
                for (int i = 1; i < n; i++) {
                    // Each character can either remain same or become like its left neighbor
                    if (current.charAt(i) != t.charAt(i) && current.charAt(i - 1) == t.charAt(i)) {
                        next.append(t.charAt(i)); // move toward target
                    } else {
                        next.append(current.charAt(i));
                    }
                }
                steps++;
                current = next.toString();

                if (current.equals(t)) {
                    possible = true;
                    break;
                }
            }

            if (possible) {
                System.out.println(steps);
            } else {
                System.out.println(-1);
            }
        }
    }
}
