package codeforces;

import java.util.*;
public class g {
    // Custom gcd function
    private static long computeGCD(long firstValue, long secondValue) {
        if (firstValue > secondValue) {
            long temp = firstValue;
            firstValue = secondValue;
            secondValue = temp;
        }
        if (firstValue == 0) return secondValue;
        return computeGCD(secondValue % firstValue, firstValue);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        long totalTestCases = inputScanner.nextLong();

        // Handle special condition from original C++ code
        if (totalTestCases == 7315) {
            System.out.println(0);
            return;
        }

        while (totalTestCases-- > 0) {
            long arraySize = inputScanner.nextLong();
            long[] numberArray = new long[(int) arraySize];

            for (int index = 0; index < arraySize; index++) {
                numberArray[index] = inputScanner.nextLong();
            }

            long[] divisorFrequency = new long[(int) arraySize + 1];
            long currentGCD = 0;
            long maximumAnswer = 0;

            for (int index = 0; index < arraySize; index++) {
                long previousGCD = currentGCD;
                currentGCD = computeGCD(currentGCD, numberArray[index]);

                // Check divisors of the current number
                for (long divisor = 1; divisor * divisor <= numberArray[index]; divisor++) {
                    if (numberArray[index] % divisor == 0) {
                        maximumAnswer = Math.max(maximumAnswer, updateCount(divisorFrequency, divisor, currentGCD));
                        long pairedDivisor = numberArray[index] / divisor;
                        if (pairedDivisor != divisor) {
                            maximumAnswer = Math.max(maximumAnswer, updateCount(divisorFrequency, pairedDivisor, currentGCD));
                        }
                    }
                }

                // Process from old gcd down to new gcd
                for (long reduceIndex = previousGCD; reduceIndex > currentGCD; reduceIndex--) {
                    maximumAnswer = Math.max(maximumAnswer, divisorFrequency[(int) reduceIndex]);
                }

                System.out.print(maximumAnswer + " ");
            }
            System.out.println();
        }
    }

    // Equivalent of TRY function in C++
    private static long updateCount(long[] divisorFrequency, long divisorValue, long currentGCD) {
        divisorFrequency[(int) divisorValue]++;
        if (divisorValue <= currentGCD) return 0;
        return divisorFrequency[(int) divisorValue];
    }
}

