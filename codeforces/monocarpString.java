package codeforces;

import java.io.*;
import java.util.*;
public class monocarpString {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int t = Integer.parseInt(reader.readLine().trim());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(reader.readLine().trim());
            String s = reader.readLine().trim();

            int countA = 0, countB = 0;
            for (char c : s.toCharArray()) {
                if (c == 'a') countA++;
                else countB++;
            }

            // if impossible or requires deleting all (all same letter) -> -1
            if (countA == 0 || countB == 0) {
                result.append("-1\n");
                continue;
            }

            // if already equal -> 0
            if (countA == countB) {
                result.append("0\n");
                continue;
            }

            int totalDiff = countA - countB; // needed difference to remove: ra - rb = totalDiff

            Map<Integer, Integer> firstPos = new HashMap<>();
            firstPos.put(0, -1);
            int prefix = 0;
            int minLen = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                prefix += (s.charAt(i) == 'a') ? 1 : -1;
                // prefix[i] - prefix[j] = totalDiff  ->  prefix[j] = prefix[i] - totalDiff
                int need = prefix - totalDiff;
                if (firstPos.containsKey(need)) {
                    int start = firstPos.get(need);
                    int len = i - start;
                    if (len < minLen) minLen = len;
                }
                firstPos.putIfAbsent(prefix, i);
            }

            // If not found or only solution is removing entire string -> -1
            if (minLen == Integer.MAX_VALUE || minLen == n) {
                result.append("-1\n");
            } else {
                result.append(minLen).append('\n');
            }
        }

        System.out.print(result.toString());
    }
}
