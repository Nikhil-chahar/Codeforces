
import  java.util.*;
public class c3 {
    public static void main(String[] args) {
        Scanner nm=new Scanner(System.in);
        int n = nm.nextInt();
        for(int i=0;i<n;i++){
           int m= nm.nextInt();
          PriorityQueue<Integer> li = new PriorityQueue<>();
           for(int j=0;j<m;j++){
               int b=nm.nextInt();
               li.add(b);   
           }
           while(li.size()>=2){
               int s1= li.poll();
               int s2= li.poll();
               int s3= s2+s1-1;
              
               li.add(s3);
           }
           System.out.println(p.poll());
        }
    }
}