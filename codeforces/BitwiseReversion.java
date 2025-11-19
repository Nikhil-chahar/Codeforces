package codeforces;
import java.util.*;

public class BitwiseReversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();

        for (int i = 0; i < test; i++) {
            int A = scan.nextInt(); 
            int B = scan.nextInt(); 
            int C = scan.nextInt(); 
            int invalid = (A & B & ~C) | (A & C & ~B) | (B & C & ~A);

            if (invalid == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
