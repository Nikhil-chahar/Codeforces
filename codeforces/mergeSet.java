package codeforces;
import java.util.*;
public class mergeSet {

    public static boolean Merge(int n, int m, List<List<Integer>> Set) {
        int[] co = new int[m + 1];

        for (List<Integer> s : Set) {
            for (int x : s) {
                co[x]++;
            }
        }

        for (int i = 1; i <= m; i++) {
            if (co[i] == 0) {
                return false;
            }
        }

        int oWay = 0;

        for (List<Integer> s : Set) {
            boolean Rem = true;
            for (int x : s) {
                if (co[x] == 1) {
                    Rem = false;
                    break;
                }
            }
            if (Rem) {
                oWay++;
            }
            if (oWay >= 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Integer>> Set = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int size = sc.nextInt(); 
                List<Integer> s = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    s.add(sc.nextInt());
                }
                Set.add(s);
            }
            
            if(Merge(n, m, Set)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
