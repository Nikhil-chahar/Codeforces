package codeforces;

import java.util.*;
public class Destruction {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int testCases = inputScanner.nextInt();

        while (testCases-- > 0) {
            int arraySize = inputScanner.nextInt();
            long[] numbersArray = new long[arraySize];

            for (int index = 0; index < arraySize; index++) {
                numbersArray[index] = inputScanner.nextLong();
            }

            List<Long> oddNumbersList = new ArrayList<>();
            long sumOfEvens = 0;

            for (long currentNumber : numbersArray) {
                if (currentNumber % 2 == 0) {
                    sumOfEvens += currentNumber;
                } else {
                    oddNumbersList.add(currentNumber);
                }
            }

            long maximumPoints = 0;
            int oddCount = oddNumbersList.size();

            if (oddCount == 0) {
                maximumPoints = 0;
            } else {
                Collections.sort(oddNumbersList);

                long sumOfSmallOdds = 0;
                int countSmallOdds = oddCount / 2;

                for (int idx = 0; idx < countSmallOdds; idx++) {
                    sumOfSmallOdds += oddNumbersList.get(idx);
                }

                long totalOddSum = 0;
                for (long oddValue : oddNumbersList) {
                    totalOddSum += oddValue;
                }

                long selectedOddSum = totalOddSum - sumOfSmallOdds;
                maximumPoints = selectedOddSum + sumOfEvens;
            }

            System.out.println(maximumPoints);
        }
    }
}
