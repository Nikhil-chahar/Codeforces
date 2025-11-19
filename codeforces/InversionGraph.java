package codeforces;
import java.util.*;

public class InversionGraph {
    static final int MOD = 1000000007;

    static int addMod(int a, int b) {
        a += b;
        if (a >= MOD) a -= MOD;
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] originalArray = new int[n];
            for (int i = 0; i < n; i++) {
                originalArray[i] = scanner.nextInt();
            }

            // Coordinate compression
            int[] sortedArray = Arrays.copyOf(originalArray, n);
            Arrays.sort(sortedArray);
            int compressedSize = 0;
            Map<Integer, Integer> compressionMap = new HashMap<>();
            for (int value : sortedArray) {
                if (!compressionMap.containsKey(value)) {
                    compressionMap.put(value, ++compressedSize);
                }
            }
            for (int i = 0; i < n; i++) {
                originalArray[i] = compressionMap.get(originalArray[i]); // compressed 1..m
            }

            // dp[lastPileA][lastPileB]
            int[][] dp = new int[compressedSize + 1][compressedSize + 1];
            dp[0][0] = 1; // empty subsequence

            for (int index = 0; index < n; index++) {
                int currentValue = originalArray[index];
                int[][] nextDp = new int[compressedSize + 1][compressedSize + 1];

                for (int lastA = 0; lastA <= compressedSize; lastA++) {
                    for (int lastB = 0; lastB <= compressedSize; lastB++) {
                        int currentWays = dp[lastA][lastB];
                        if (currentWays == 0) continue;

                        // Skip option
                        nextDp[lastA][lastB] = addMod(nextDp[lastA][lastB], currentWays);

                        // Place in pile A
                        if (lastA <= currentValue) {
                            nextDp[currentValue][lastB] = addMod(nextDp[currentValue][lastB], currentWays);
                        }
                        // Place in pile B
                        else if (lastB <= currentValue) {
                            nextDp[lastA][currentValue] = addMod(nextDp[lastA][currentValue], currentWays);
                        }
                        // else → cannot place (would need 3rd pile)
                    }
                }
                dp = nextDp;
            }

            int answer = 0;
            for (int lastA = 0; lastA <= compressedSize; lastA++) {
                for (int lastB = 0; lastB <= compressedSize; lastB++) {
                    answer = addMod(answer, dp[lastA][lastB]);
                }
            }

            System.out.println(answer);
        }
    }
}
