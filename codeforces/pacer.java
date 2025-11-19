package codeforces;

import java.util.*;

public class pacer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int points = 0;
            int currentSide = 0;
            int lastAudioMinute = 0;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (currentSide == b) {
                    points += a - lastAudioMinute;
                } else {
                    points += (a - lastAudioMinute) - 1;
                }
                currentSide = b;
                lastAudioMinute = a;
            }
            if (currentSide == 0) {
                points += m - lastAudioMinute;
            } else {
                points += (m - lastAudioMinute);
            }
            System.out.println(points);

        }
    }
}

