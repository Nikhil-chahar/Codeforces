package codeforces;

import java.io.*;

public class DeckOfCards {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder fin = new StringBuilder();

        int test = Integer.parseInt(reader.readLine().trim());

        for (int tc = 0; tc < test; tc++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input[0]); // 
            int k = Integer.parseInt(input[1]); // 
            String s = reader.readLine().trim();

            int top = 0, last = 0, notSure = 0;
            for (char chr : s.toCharArray()) {
                if (chr == '0') top++;
                else if (chr == '1') last++;
                else notSure++;
            }

            char[] result = new char[n];
            int ri = n - (last + notSure); 

            for (int card = 1; card <= n; card++) {
                int minX = Math.max(0, card - ri);
                int maxX = Math.min(notSure, card - top - 1);

                if (minX > maxX) {
                    result[card - 1] = '-'; 
                } else if (card > top + notSure && card <= n - last - notSure) {
                    result[card - 1] = '+'; 
                } else {
                    result[card - 1] = '?'; 
                }
            }

            fin.append(new String(result)).append('\n');
        }

        System.out.print(fin.toString());
    }
}
