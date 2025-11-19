package codeforces;

import java.io.*;
import java.util.*;

public class rabbits {

    static class DisSet {
        int len;
        int[] pArr, XOR;

        DisSet(int n) {
            len = n;
            pArr = new int[n];
            XOR = new int[n];
            for (int i = 0; i < n; i++) {
                pArr[i] = i;
                XOR[i] = 0;
            }
        }

        int[] find(int v) {
            if (pArr[v] == v) return new int[]{v, 0};
            int[] res = find(pArr[v]);
            pArr[v] = res[0];
            XOR[v] ^= res[1];
            return new int[]{pArr[v], XOR[v]};
        }

        boolean merge(int u, int v, int weight) {
            int[] le = find(u);
            int[] ri = find(v);
            int pu = le[0], pv = ri[0];
            int xu = le[1], xv = ri[1];

            if (pu == pv) {
                return ((xu ^ xv) == weight);
            }
            pArr[pu] = pv;
            XOR[pu] = xu ^ xv ^ weight;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder opCol = new StringBuilder();
        int testRuns = Integer.parseInt(br.readLine());

        while (testRuns-- > 0) {
            int lenString = Integer.parseInt(br.readLine());
            String binaryString = br.readLine();

            int[] indexMap = new int[lenString];
            Arrays.fill(indexMap, -1);

            List<Integer> zPos = new ArrayList<>();
            for (int i = 0; i < lenString; i++) {
                if (binaryString.charAt(i) == '0') {
                    indexMap[i] = zPos.size();
                    zPos.add(i);
                }
            }

            int zeroCount = zPos.size();
            DisSet dsu = new DisSet(zeroCount + 1);
            boolean isP = true;
            int snode = zeroCount;

            for (int i = 0; i < lenString && isP; i++) {
                if (binaryString.charAt(i) == '1') {
                    int leNei = (i > 0 && binaryString.charAt(i - 1) == '0') ? indexMap[i - 1] : -1;
                    int riNei = (i + 1 < lenString && binaryString.charAt(i + 1) == '0') ? indexMap[i + 1] : -1;

                    if (leNei != -1 && riNei != -1) {
                        if (!dsu.merge(leNei, riNei, 1)) isP = false;
                    } else if (leNei != -1) {
                        if (!dsu.merge(leNei, snode, 0)) isP = false;
                    } else if (riNei != -1) {
                        if (!dsu.merge(riNei, snode, 1)) isP = false;
                    }
                }
            }

            opCol.append(isP ? "YES\n" : "NO\n");
        }
        System.out.print(opCol);
    }
}

