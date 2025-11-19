package codeforces;
import java.util.*;

public class equalOcc {
    
    public static int find(int[] arr) {
        int n = arr.length;
        List<Integer> fList = new ArrayList<>();
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                fList.add(count);
                count = 1;
            }
        }
        fList.add(count);

        int ans = 0;
        int max = Collections.max(fList);

        for (int k = 1; k <= max; k++) {
            int c = 0;
            for (int f : fList) {
                if (f >= k) c++;
            }
            ans = Math.max(ans, c * k);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(find(arr));
        }
    }
}
