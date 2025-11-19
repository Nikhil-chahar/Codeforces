package codeforces;
import java.util.*;
public class sequenceGame {
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);
        int test = nm.nextInt();

        for(int t=1;t<=test;t++){
            int len = nm.nextInt();
            int array[] = new int[len];
            for(int i=0;i<len;i++){
                array[i] = nm.nextInt();
            }
            int value= nm.nextInt();
            int minvalue = Integer.MAX_VALUE;
            int maxvalue = Integer.MIN_VALUE;
            for(int i=0;i<len;i++){
                if(maxvalue < array[i]){
                    maxvalue = array[i];
                }
                if(minvalue > array[i]){
                    minvalue = array[i];
                }
            }
            if(value >= minvalue && value <= maxvalue){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }

    }
}
