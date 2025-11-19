package codeforces;
import java.util.*;

public class evenModulePair {
    public static void main(String[] args){
        Scanner nm = new Scanner(System.in);
        int test = nm.nextInt();
        for(int t=1;t<=test;t++){
            int len = nm.nextInt();
            int arr[] = new int[len];
            for (int i = 0; i < len; i++){
                 arr[i] = nm.nextInt();
            }
            ArrayList<Integer> even = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (arr[i] % 2 == 0){
                    even.add(i);
                }
            }
            boolean fnd = false;
            if (even.size() >= 2) {
                System.out.println(arr[even.get(0)] + " " + arr[even.get(1)]);
                continue;
            }
            for (int i = 0; i < len && !fnd; i++) {
                int mn = Math.min(len, i + 101);
                for (int j = i + 1; j < mn; j++) {
                    if ((arr[j] % arr[i]) % 2 == 0) {
                        System.out.println(arr[i] + " " + arr[j]);
                        fnd = true;
                        break;
                    }
                }
            }
            if(!fnd){
                System.out.println(-1);
            }
                
        }
    }
}