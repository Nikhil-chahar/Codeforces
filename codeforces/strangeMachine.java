package codeforces;
import java.util.*;

public class strangeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int str = sc.nextInt();
            int qcnt = sc.nextInt();
            String pattern = sc.next();

            long[] Q = new long[qcnt];
            for (int i = 0; i < qcnt; i++) {
                Q[i] = sc.nextLong();
            }

            boolean haveB = false;
            for (char ch : pattern.toCharArray()) {
                if (ch == 'B') {
                    haveB = true;
                    break;
                }
            }

            for (long energy : Q) {
                if (!haveB) {
                    System.out.println(energy);
                    continue;
                }

                long res = 0;
                int ind = 0;

                while (energy > 0) {
                    int countA = 0;
                    int temInd = ind;

                    while (pattern.charAt(temInd) == 'A') {
                        countA++;
                        temInd = (temInd + 1 == str ? 0 : temInd + 1);
                        if (temInd == ind) break; 
                    }

                    long usableA = Math.min(countA, energy);
                    energy -= usableA;
                    res += usableA;
                    ind = (int) ((ind + usableA) % str);

                    if (energy == 0) break;

                    if (pattern.charAt(ind) == 'B') {
                        energy = energy / 2;
                        res++;
                        if (ind + 1 == str) {
                            ind = 0;
                        } else {
                            ind = ind + 1;
                        }
                    }
                }

                System.out.println(res);
            }
        }
    }
}

