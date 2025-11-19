package codeforces;

import java.io.*;
import java.util.*;

public class gameOnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader readerObj = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder finalAnswer = new StringBuilder();
        int totalCases = Integer.parseInt(readerObj.readLine().trim());

        // switched while → for
        for (int testIndex = 0; testIndex < totalCases; testIndex++) {
            int arraySize = Integer.parseInt(readerObj.readLine().trim());
            long[] numberList = new long[arraySize];
            String[] inputParts = readerObj.readLine().trim().split(" ");

            // switched for → while
            int idx = 0;
            while (idx < arraySize) {
                numberList[idx] = Long.parseLong(inputParts[idx]);
                idx++;
            }

            HashMap<Long, Integer> frequencyMap = new HashMap<>();
            idx = 0;
            while (idx < arraySize) {
                long val = numberList[idx];
                frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
                idx++;
            }

            long[] tokenBucket = new long[arraySize + 1];
            for (Map.Entry<Long, Integer> element : frequencyMap.entrySet()) {
                long number = element.getKey();
                int count = element.getValue();
                tokenBucket[count] += number;
            }

            long aliceScore = 0, bobScore = 0;
            long turnCounter = 0;

            int weight = arraySize;
            while (weight >= 1) {
                long collected = tokenBucket[weight];
                if (collected != 0) {
                    int currentTurn = (int) (turnCounter % 2);
                    long aliceTake = (collected + (1 - currentTurn)) / 2;
                    long bobTake = collected - aliceTake;

                    aliceScore += aliceTake * weight;
                    bobScore += bobTake * weight;
                    turnCounter += collected;
                }
                weight--;
            }

            finalAnswer.append(aliceScore).append(" ").append(bobScore).append("\n");
        }

        System.out.print(finalAnswer);
    }
}
