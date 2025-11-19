package codeforces;
import java.util.*;

class alternatingseries{
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);
        
        if (!nm.hasNextInt()) return;
        int tes = nm.nextInt();
        
         while (tes -- > 0) {
            int len = nm.nextInt();
            for (int index = 1; index <= len; index++) {
                long outputValue;
                if ((index & 1) == 1) {
                    outputValue = -1;
                } else {
                    outputValue = (index == len ? 2 : 3);
                }
                System.out.print(outputValue + (index == len ? "\n" : " "));
            }
        }
    }
}