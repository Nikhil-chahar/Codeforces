package codeforces;
import java.util.*;

class queueAtSchool{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t =sc.nextInt();

        String s = sc.next();
        char ss[] = s.toCharArray();

        while(t-- >0){
            for(int i=0;i<s.length()-1;i++){
                if(ss[i] == 'B' && ss[i+1] == 'G'){
                    ss[i] ='G';
                    ss[i+1] = 'B';
                    i+=1;
                }
            }
        }
        String str = new String(ss);
        System.out.println(str);


    }
}