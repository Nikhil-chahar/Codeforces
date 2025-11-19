package codeforces;
import java.util.*;

class beautifulYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        for(int i=year+1;year <=9000;i++){
            if(isDis(i)){
                System.out.println(i);
                break;
            }
        }
    }
    public static boolean isDis(int year){
        String s = Integer.toString(year);
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        for(char key : map.keySet()){
            if(map.get(key) >1){
                return false;
            }
        }
        return true;
    }
}