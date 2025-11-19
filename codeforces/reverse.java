package codeforces;

import java.util.*;
public class reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'A']++;
            }
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                if (i != 'F' - 'A' && i != 'T' - 'A' && i != 'N' - 'A') {
                    while (freq[i]-- > 0) result.append((char) (i + 'A'));
                }
            }
            while (freq['T' - 'A']-- > 0) result.append('T');
            while (freq['N' - 'A']-- > 0) result.append('N');
            while (freq['F' - 'A']-- > 0) result.append('F');
            

            System.out.println(result.toString());
        }
    }
}

