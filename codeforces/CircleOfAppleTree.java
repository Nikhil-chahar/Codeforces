package codeforces;
import java.util.*;

public class CircleOfAppleTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt(); // number of test cases

        for (int t = 0; t < test; t++) {
            int tree = scanner.nextInt(); // number of apple trees
            int[] appleT = new int[tree];

            for (int i = 0; i < tree; i++) {
                appleT[i] = scanner.nextInt();
            }

            Arrays.sort(appleT);

            int Cnt = 1;
            int val = appleT[0];

            for (int i = 1; i < tree; i++) {
                if (appleT[i] > val) {
                    Cnt++;
                    val = appleT[i];
                }
            }

            System.out.println(Cnt);
        }
    }
}
