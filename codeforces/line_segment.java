

package codeforces;
import java.util.*;

public class line_segment {

    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static String solve(int n, long px, long py, long qx, long qy, int[] a) {
        long dx_diff = qx - px;
        long dy_diff = qy - py;
        long target_dist_sq = dx_diff * dx_diff + dy_diff * dy_diff;

        long currentMinReach = 0;
        long currentMaxReach = 0;

        for (int val : a) {
            long d_val = val;
            currentMinReach = Math.abs(currentMinReach - d_val);
            currentMaxReach = currentMaxReach + d_val;
        }

        long sqrt_target_dist_sq = (long) Math.sqrt(target_dist_sq);
        if (sqrt_target_dist_sq * sqrt_target_dist_sq != target_dist_sq) {
            return "No";
        }

        long targetDistanceInt = sqrt_target_dist_sq;

        if (targetDistanceInt < currentMinReach || targetDistanceInt > currentMaxReach) {
            return "No";
        }

        if ((currentMaxReach - targetDistanceInt) % 2 != 0) {
            return "No";
        }

        return "Yes";
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();

            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                long px = sc.nextLong();
                long py = sc.nextLong();
                long qx = sc.nextLong();
                long qy = sc.nextLong();
                int[] a = new int[n];
                for (int j = 0; j < n; j++) {
                    a[j] = sc.nextInt();
                }
                System.out.println(solve(n, px, py, qx, qy, a));
            }
        }
    }
}
