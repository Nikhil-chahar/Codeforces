package codeforces;

import java.util.*;

public class makeItEqual {
    public static void main(String[] args) {
        Scanner nm = new Scanner(System.in);

        if (!nm.hasNextInt()) return;
        int Cas = nm.nextInt();

        while (Cas-- > 0) {
            long sizeN = nm.nextLong();
            long divK = nm.nextLong();

            long[] listA = new long[(int) sizeN];
            long[] listB = new long[(int) sizeN];

            int indexA = 0;
            while (indexA < sizeN) {
                listA[indexA] = nm.nextLong();
                indexA++;
            }

            int indexB = 0;
            while (indexB < sizeN) {
                listB[indexB] = nm.nextLong();
                indexB++;
            }

            indexA = 0;
            while (indexA < sizeN) {
                long rem1 = listA[indexA] % divK;
                long rem2 =  (divK - rem1) % divK;
                listA[indexA] = Math.min(rem1, rem2);
                indexA++;
            }

            indexB = 0;
            while (indexB < sizeN) {
                long rem1 = listB[indexB] % divK;
                long rem2 =  (divK - rem1) % divK;
                listB[indexB] = Math.min(rem1, rem2);
                indexB++;
            }

            Arrays.sort(listA);
            Arrays.sort(listB);

            if (Arrays.equals(listA, listB)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
