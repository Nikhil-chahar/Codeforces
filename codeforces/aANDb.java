package codeforces;
import java.util.*;
public class aANDb{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while (t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            List<Integer> list1=new ArrayList<>();
            List<Integer> list2=new ArrayList<>();
            
            for (int i=0;i<n;i++){
                if (s.charAt(i)=='a') 
                    list1.add(i);
                else list2.add(i);
            }
            
            long prA=calculation(list1);
            long prB=calculation(list2);
            
            System.out.println(Math.min(prA, prB));
        }
        
    }
    private static long calculation(List<Integer> ll) {
        if (ll.isEmpty()) return 0;
        int m = ll.size();
        int mInd=m/2;
        int med=ll.get(mInd);
        
        long price=0;
        for (int i=0;i<m;i++){
            price += Math.abs(ll.get(i) - (med-mInd+i));
        }
        return price;
    }
}