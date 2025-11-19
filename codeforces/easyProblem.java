package codeforces;
import java.util.*;
public class easyProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n -- >0){
            int val = sc.nextInt();
            if(val == 1){
                System.out.println("Hard");
                return;
            }
        }
        System.out.println("Easy");

    }
}
