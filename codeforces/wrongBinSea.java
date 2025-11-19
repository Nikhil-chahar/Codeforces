package codeforces;

import java.util.*;

public class wrongBinSea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            List<Integer> stableIndices = new ArrayList<>();
            List<Integer> unstableIndices = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    stableIndices.add(i + 1);
                } else {
                    unstableIndices.add(i + 1);
                }
            }

            if (stableIndices.isEmpty()) {
                System.out.println("YES");
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                continue;
            }

            boolean possible = true;
            if (stableIndices.size() > 1) {
                for (int i = 0; i < stableIndices.size() - 1; i++) {
                    int consecutiveUnstableCount = stableIndices.get(i + 1) - stableIndices.get(i) - 1;
                    if (consecutiveUnstableCount < 2) {
                        possible = false;
                        break;
                    }
                }
            }
            
            if (!unstableIndices.isEmpty() && (unstableIndices.get(0) > stableIndices.get(0) || unstableIndices.get(unstableIndices.size() - 1) < stableIndices.get(stableIndices.size() - 1))) {
                possible = false;
            }

            if (unstableIndices.size() > 1 && unstableIndices.get(unstableIndices.size() - 1) - unstableIndices.get(0) > 2) {
                possible = false;
            }

            if (stableIndices.get(0) < unstableIndices.get(unstableIndices.size() - 1) && unstableIndices.size() > 1 && stableIndices.get(stableIndices.size() - 1) > unstableIndices.get(0)) {
                int firstStableIndex = stableIndices.get(0);
                int lastStableIndex = stableIndices.get(stableIndices.size() - 1);
                
                if (firstStableIndex > 1 || lastStableIndex < n) {
                    int unstableLeftCount = 0;
                    for (int unstableIndex : unstableIndices) {
                        if (unstableIndex < firstStableIndex) {
                            unstableLeftCount++;
                        }
                    }
                    int unstableRightCount = 0;
                    for (int unstableIndex : unstableIndices) {
                        if (unstableIndex > lastStableIndex) {
                            unstableRightCount++;
                        }
                    }
                    if (unstableLeftCount > 1 || unstableRightCount > 1) {
                        possible = false;
                    }
                }
            }


            if (!possible) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                int[] p = new int[n];
                int st = 0, un = 0;

                for (int i = 0; i < n; i++) {
                    if (st < stableIndices.size() && (un >= unstableIndices.size() || stableIndices.get(st) < unstableIndices.get(un))) {
                        p[i] = stableIndices.get(st++);
                    } else {
                        p[i] = unstableIndices.get(un++);
                    }
                }
                for (int i = 0; i < n; i++) {
                    System.out.print(p[i] + " ");
                }
                System.out.println();
            }
        }
    }
}