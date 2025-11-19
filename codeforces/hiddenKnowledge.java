package codeforces;
import java.io.*;
import java.util.*;

public class hiddenKnowledge {
    static class FastScanner {
        private final InputStream inputStream;
        private final byte[] readBuffer = new byte[1 << 16];
        private int bufferPointer = 0, bytesRead = 0;

        FastScanner(InputStream is) {
            inputStream = is;
        }

        private int readByte() throws IOException {
            if (bufferPointer >= bytesRead) {
                bytesRead = inputStream.read(readBuffer);
                bufferPointer = 0;
                if (bytesRead <= 0) return -1;
            }
            return readBuffer[bufferPointer++];
        }

        int nextInt() throws IOException {
            int currentChar;
            while ((currentChar = readByte()) <= 32) {
                if (currentChar == -1) return Integer.MIN_VALUE;
            }
            int signValue = 1;
            if (currentChar == '-') {
                signValue = -1;
                currentChar = readByte();
            }
            int resultValue = 0;
            while (currentChar > 32) {
                resultValue = resultValue * 10 + (currentChar - '0');
                currentChar = readByte();
            }
            return resultValue * signValue;
        }
    }

    static long countAtMostKWithLimit(int[] arr, int maxDistinct, int maxSubLen) {
        if (maxDistinct < 0 || maxSubLen <= 0) return 0L;
        int arrLen = arr.length;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int leftPtr = 0;
        int distinctCount = 0;
        long totalCount = 0L;

        for (int rightPtr = 0; rightPtr < arrLen; rightPtr++) {
            int currentVal = arr[rightPtr];
            int freqVal = frequencyMap.getOrDefault(currentVal, 0) + 1;
            frequencyMap.put(currentVal, freqVal);

            if (freqVal == 1) distinctCount++;

            while (distinctCount > maxDistinct) {
                int leftVal = arr[leftPtr];
                int leftFreq = frequencyMap.get(leftVal);
                if (leftFreq == 1) {
                    frequencyMap.remove(leftVal);
                    distinctCount--;
                } else {
                    frequencyMap.put(leftVal, leftFreq - 1);
                }
                leftPtr++;
            }

            long subLen = rightPtr - leftPtr + 1L;
            if (subLen > 0) {
                totalCount += Math.min(subLen, (long) maxSubLen);
            }
        }
        return totalCount;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder outputBuilder = new StringBuilder();
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int arrSize = scanner.nextInt();
            int requiredK = scanner.nextInt();
            int leftBound = scanner.nextInt();
            int rightBound = scanner.nextInt();

            int[] inputArray = new int[arrSize];
            for (int idx = 0; idx < arrSize; idx++) inputArray[idx] = scanner.nextInt();

            long atMostKRight = countAtMostKWithLimit(inputArray, requiredK, rightBound);
            long atMostKMinusOneRight = countAtMostKWithLimit(inputArray, requiredK - 1, rightBound);
            long atMostKLeftMinusOne = countAtMostKWithLimit(inputArray, requiredK, leftBound - 1);
            long atMostKMinusOneLeftMinusOne = countAtMostKWithLimit(inputArray, requiredK - 1, leftBound - 1);

            long exactKRight = atMostKRight - atMostKMinusOneRight;
            long exactKLeftMinusOne = atMostKLeftMinusOne - atMostKMinusOneLeftMinusOne;

            long finalAnswer = exactKRight - exactKLeftMinusOne;
            outputBuilder.append(finalAnswer).append('\n');
        }

        System.out.print(outputBuilder.toString());
    }
}
