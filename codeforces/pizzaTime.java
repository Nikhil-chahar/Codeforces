package codeforces;
import java.util.*;
public class pizzaTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(maxPizzaSlices(n));
        }
    }
    public static long maxPizzaSlices(long n) {
        if (n <= 2) return n;

        if (n % 3 == 2) return n / 3 + 1;
        return n / 3;
    }
}
