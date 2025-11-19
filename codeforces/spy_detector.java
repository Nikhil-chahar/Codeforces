package codeforces;

import java.util.*;
public class spy_detector {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- >0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }

            int ans=0;
            for(int key : map.keySet()){
                if(map.get(key) == 1){
                    ans = key;
                    break;
                }
            }
            for(int i=0;i<n;i++){
                if(arr[i] == ans){
                    ans = i+1;
                }
            }

            System.out.println(ans);
            
        }
    }
}
