
import java.util.*;
public class Main {
    public static void main(String Args[]){
        Scanner nm = new Scanner(System.in);
        int n = nm.nextInt();
        if(n>2 && n%2==0){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
    }
}