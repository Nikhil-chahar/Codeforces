package codeforces;
import java.util.*;

public class dungeon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int tc = 1; tc <= testCases; tc++) {
            int swCnt = scanner.nextInt();
            int mnCnt = scanner.nextInt();
            long[] swords = new long[swCnt];
            for (int i = 0; i < swCnt; i++) {
                swords[i] = scanner.nextLong();
            }
            long[] mntCnt = new long[mnCnt];
            long[] upgradePower = new long[mnCnt];
            for (int i = 0; i < mnCnt; i++) {
                mntCnt[i] = scanner.nextLong();
            }
            for (int i = 0; i < mnCnt; i++) {
                upgradePower[i] = scanner.nextLong();
            }
            List<long[]> upmnt = new ArrayList<>();
            List<long[]> normalMonsters = new ArrayList<>();
            for (int i = 0; i < mnCnt; i++) {
                if (upgradePower[i] > 0) {
                    upmnt.add(new long[]{mntCnt[i], upgradePower[i]});
                } else {
                    normalMonsters.add(new long[]{mntCnt[i], upgradePower[i]});
                }
            }
            TreeMap<Long, Integer> swordSet = new TreeMap<>();
            for (long sword : swords) {
                swordSet.put(sword, swordSet.getOrDefault(sword, 0) + 1);
            }
            upmnt.sort(Comparator.comparingLong(o -> o[0]));
            int totalKills = 0;
            for (long[] monster : upmnt) {
                long monsterLife = monster[0];
                long upgradedSwordPower = monster[1];

                Map.Entry<Long, Integer> swordEntry = swordSet.ceilingEntry(monsterLife);
                if (swordEntry != null) {
                    long currentSword = swordEntry.getKey();
                    if (swordEntry.getValue() == 1) {
                        swordSet.remove(currentSword);
                    } else {
                        swordSet.put(currentSword, swordEntry.getValue() - 1);
                    }
                    long upgradedSword = Math.max(currentSword, upgradedSwordPower);
                    swordSet.put(upgradedSword, swordSet.getOrDefault(upgradedSword, 0) + 1);
                    totalKills++;
                }
            }
            List<Long> remainingSwords = new ArrayList<>();
            for (Map.Entry<Long, Integer> entry : swordSet.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    remainingSwords.add(entry.getKey());
                }
            }
            Collections.sort(remainingSwords);
            normalMonsters.sort(Comparator.comparingLong(o -> o[0]));
            int swordIndex = 0, monsterIndex = 0;
            while (swordIndex < remainingSwords.size() && monsterIndex < normalMonsters.size()) {
                if (remainingSwords.get(swordIndex) >= normalMonsters.get(monsterIndex)[0]) {
                    totalKills++;
                    swordIndex++;
                    monsterIndex++;
                } else {
                    swordIndex++;
                }
            }
            System.out.println(totalKills);
        }
    }
}
