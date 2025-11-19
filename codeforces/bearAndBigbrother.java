package codeforces;
import java.util.*;
public class bearAndBigbrother {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int sm = sc.nextInt();
        int lr = sc.nextInt();

        int y=0;
        while(sm <= lr){
            sm *=3;
            lr *=2;
            y++;
        }

        System.out.println(y);
    }
}
