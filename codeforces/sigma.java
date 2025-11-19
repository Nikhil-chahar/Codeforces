package codeforces;
import java.util.*;
public class sigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        
        int t = sc.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of arrays
            int m = sc.nextInt(); // Size of each array
            
            long[][] arrays = new long[n][m];
            long[] prefixSums = new long[n];
            
            for (int i = 0; i < n; i++) {
                long sum = 0;
                for (int j = 0; j < m; j++) {
                    arrays[i][j] = sc.nextInt();
                    sum += arrays[i][j];
                }
                prefixSums[i] = sum;
            }
            
            Arrays.sort(prefixSums);
            
            long maxScore = 0;
            long cumulativeSum = 0;
            for (long sum : prefixSums) {
                cumulativeSum += sum;
                maxScore += cumulativeSum;
            }
            
            output.append(maxScore).append("\n");
        }
        
        System.out.print(output);
        sc.close();
    }
}

