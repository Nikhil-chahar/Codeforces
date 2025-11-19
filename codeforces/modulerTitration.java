package codeforces;

import java.io.*;
import java.util.*;
public class modulerTitration {
    static final int MODULO = 998244353;
    static final int LIMIT = 1_000_000;
    static int[] sPrime = new int[LIMIT + 1];
    static int[] inver = new int[LIMIT + 1];

    // Modular exiation
    static long modex(long base, int exp) {
        long result = 1 % MODULO;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MODULO;
            }
            base = (base * base) % MODULO;
            exp >>= 1;
        }
        return result;
    }

    // Build smallest prime factor (linear sieve)
    static void buildsPrime() {
        Arrays.fill(sPrime, 0);
        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= LIMIT; i++) {
            if (sPrime[i] == 0) {
                sPrime[i] = i;
                primeList.add(i);
            }
            for (int p : primeList) {
                if ((long) p * i > LIMIT) break;
                sPrime[p * i] = p;
                if (p == sPrime[i]) break;
            }
        }
        sPrime[1] = 1;
    }

    // Factorization using SPF
    static List<int[]> fNum(int num) {
        List<int[]> factors = new ArrayList<>();
        if (num <= 1) return factors;
        while (num > 1) {
            int prime = sPrime[num], count = 0;
            while (num % prime == 0) {
                num /= prime;
                count++;
            }
            factors.add(new int[]{prime, count});
        }
        return factors;
    }

    public static void main(String[] args) throws IOException {
        buildsPrime();

        // Precompute inverses
        inver[1] = 1;
        for (int i = 2; i <= LIMIT; i++) {
            inver[i] = (int) ((1L * (MODULO - MODULO / i) * inver[MODULO % i]) % MODULO);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder oCol = new StringBuilder();
        int testCases = Integer.parseInt(reader.readLine().trim());

        while (testCases-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int numX = Integer.parseInt(st.nextToken());
            int numY = Integer.parseInt(st.nextToken());
            int numZ = Integer.parseInt(st.nextToken());

            HashMap<Integer, Integer> pCount = new HashMap<>();

            for (int[] pr : fNum(numX)) {
                pCount.put(pr[0], pCount.getOrDefault(pr[0], 0) + pr[1]);
            }
            for (int[] pr : fNum(numY)) {
                pCount.put(pr[0], pCount.getOrDefault(pr[0], 0) + pr[1]);
            }
            for (int[] pr : fNum(numZ)) {
                pCount.put(pr[0], pCount.getOrDefault(pr[0], 0) + pr[1]);
            }

            long ans = 1;
            ArrayList<Integer> disPrime = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : pCount.entrySet()) {
                int prime = entry.getKey();
                int ex = entry.getValue();
                disPrime.add(prime);

                ans = (ans * (prime - 1)) % MODULO;
                ans = (ans * modex(inver[prime], ex)) % MODULO;
            }

            HashMap<Integer, Integer> eMap = new HashMap<>();
            for (int prime : disPrime) {
                int reduced = prime - 1;
                for (int[] factor : fNum(reduced)) {
                    eMap.put(factor[0], eMap.getOrDefault(factor[0], 0) + factor[1]);
                }
            }

            HashSet<Integer> primeSet = new HashSet<>(disPrime);

            for (Map.Entry<Integer, Integer> entry : eMap.entrySet()) {
                int prime = entry.getKey();
                int ex = entry.getValue();

                if (primeSet.contains(prime)) {
                    ans = (ans * modex(inver[prime], ex)) % MODULO;
                } else {
                    long invPrime = inver[prime];
                    long iPX = modex(invPrime, ex);
                    long term = (invPrime + (((1 - invPrime + MODULO) % MODULO) * iPX) % MODULO) % MODULO;
                    ans = (ans * term) % MODULO;
                }
            }

            oCol.append(ans).append("\n");
        }

        System.out.print(oCol);
    }
}
