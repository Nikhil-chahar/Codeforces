package codeforces;
import java.util.*;
public class antonAndDanik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int anton = 0;
        int danik = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'A'){
                anton++;
            }else{
                danik++;
            }
        }
        if(anton > danik){
            System.out.println("Anton");
        }else if(danik > anton){
            System.out.println("Danik");
        }else{
            System.out.println("Friendship");
        }
    }
}
