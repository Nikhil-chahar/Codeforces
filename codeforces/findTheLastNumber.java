package codeforces;
import java.util.*;
public class findTheLastNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int totalNumbers = scanner.nextInt();
            // Initialize candidate numbers (1 to totalNumbers)
            List<Integer> candidates = new ArrayList<>();
            for (int i = 1; i <= totalNumbers; ++i) {
                candidates.add(i);
            }

            // Initialize available operations (1 to totalNumbers - 1)
            List<Integer> availableOperations = new ArrayList<>();
            for (int i = 1; i < totalNumbers; ++i) {
                availableOperations.add(i);
            }

            while (candidates.size() > 1) {
                int selectedBit = -1;
                int minimumDifference = Integer.MAX_VALUE;
                int totalCandidates = candidates.size();
                int halfCount = totalCandidates / 2;

                // Find the bit position that best divides candidates
                for (int bitPosition = 0; bitPosition < 15; ++bitPosition) {
                    int setBitCount = 0;
                    for (int number : candidates) {
                        if ((number & (1 << bitPosition)) != 0) setBitCount++;
                    }

                    if (setBitCount == 0 || setBitCount == totalCandidates) continue;

                    int difference = Math.abs(setBitCount - halfCount);
                    if (difference < minimumDifference || (difference == minimumDifference && bitPosition < selectedBit)) {
                        minimumDifference = difference;
                        selectedBit = bitPosition;
                    }
                }

                // Fallback: choose first available bit that divides candidates
                if (selectedBit == -1) {
                    for (int bitPosition = 0; bitPosition < 15; ++bitPosition) {
                        int setBitCount = 0;
                        for (int number : candidates) {
                            if ((number & (1 << bitPosition)) != 0) setBitCount++;
                        }
                        if (setBitCount > 0 && setBitCount < totalCandidates) {
                            selectedBit = bitPosition;
                            break;
                        }
                    }
                }

                int bitMask = 1 << selectedBit;
                int totalOperations = availableOperations.size();
                int[] responses = new int[totalOperations];

                // Interactive query loop
                for (int i = 0; i < totalOperations; ++i) {
                    int operationIndex = availableOperations.get(i);
                    System.out.println("? " + operationIndex + " " + bitMask);
                    System.out.flush();

                    int queryResponse = scanner.nextInt();
                    if (queryResponse == -1) return;
                    responses[i] = queryResponse;
                }

                // Analyze responses
                int yesResponseCount = 0;
                for (int res : responses) {
                    if (res == 1) yesResponseCount++;
                }

                int numbersWithSetBit = 0;
                for (int number : candidates) {
                    if ((number & bitMask) != 0) numbersWithSetBit++;
                }

                List<Integer> nextCandidates = new ArrayList<>();
                List<Integer> nextOperations = new ArrayList<>();
                int expectedResponse;

                if (yesResponseCount == numbersWithSetBit) {
                    expectedResponse = 0;
                    for (int number : candidates) {
                        if ((number & bitMask) == 0) nextCandidates.add(number);
                    }
                } else {
                    expectedResponse = 1;
                    for (int number : candidates) {
                        if ((number & bitMask) != 0) nextCandidates.add(number);
                    }
                }

                for (int i = 0; i < totalOperations; ++i) {
                    if (responses[i] == expectedResponse) {
                        nextOperations.add(availableOperations.get(i));
                    }
                }

                candidates = nextCandidates;
                availableOperations = nextOperations;
            }

            int finalAnswer = candidates.get(0);
            System.out.println("! " + finalAnswer);
            System.out.flush();
        }

    }
}
