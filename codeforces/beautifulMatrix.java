package codeforces;
import java.util.Scanner;

public class beautifulMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int grid[][] = new int[n][n];
        int row =0;
        int col =0;

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1){
                    row = i;
                    col =j;
                }
            }
        }

        System.out.println(Math.abs(row-2) + Math.abs(col-2));


    }
}
