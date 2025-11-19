
package codeforces;
import java.util.*;
public class candiesForNephews {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt(); // number of test cases
        
        while (test-- > 0) {
            int n = sc.nextInt(); // candies Monocarp has
            if(n%3 == 0){
                System.out.println(0);
            }else{
                int rem = n%3;
                System.out.println(3-rem);
            }
        }
    }
}
