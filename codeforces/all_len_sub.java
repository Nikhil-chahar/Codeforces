package codeforces;
import java.util.*;


public class all_len_sub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            int[] position = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
                position[arr[i]] = i;
            }

            int min = n + 1, max = 0, count = 0;
            boolean flag = true;

            for (int v = n; v >= 1; v--) {
                min = Math.min(min, position[v]);
                max = Math.max(max, position[v]);
                count++;
                if (max - min + 1 != count) {
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
