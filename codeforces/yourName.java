package codeforces;

import java.util.*;

public class yourName {
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);
        int test = nm.nextInt();

        while(test-- >0){
            int len = nm.nextInt();
            String str1 = nm.next();
            String str2 = nm.next();

            if(len != str1.length() || len != str2.length()){
                System.out.println("NO");
                continue;
            }

            char arr1[] = str1.toCharArray();
            char arr2[] = str2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);
            boolean fl = true;

            for(int i=0;i<len;i++){
                if(arr1[i] != arr2[i]){
                    System.out.println("NO");
                    fl = false;
                    break;
                }
            }
            if(fl){
                System.out.println("YES");
            }

        }
    }
}
