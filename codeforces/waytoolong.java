
import java.util.*;
public class waytoolong {
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);
        int t = nm.nextInt();
        while(t-- >0){
            String s = nm.next();
            if(s.length() >10){
                System.out.println(s.charAt(0) +""+ (s.length()-2) +""+ s.charAt(s.length()-1));
            }else{
                System.out.println(s);
            }
        }
    }
}
