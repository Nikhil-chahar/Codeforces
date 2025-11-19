package codeforces;

import java.util.*;
public class zeroTrailling {
    static List<Integer> primes = new ArrayList<>();
    static final int MAX = 10000010;
    static boolean[] isPrime = new boolean[MAX];
    
    static void findS() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < MAX; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (long j = (long)i * i; j < MAX; j += i) {
                    isPrime[(int)j] = false;
                }
            }
        }
    }

    // Prime factorization
    static List<int[]> primeFactorize(int number) {
        List<int[]> factors = new ArrayList<>();
        for (int prime : primes) {
            if ((long)prime * prime > number) break;
            int count = 0;
            while (number % prime == 0) {
                number /= prime;
                count++;
            }
            if (count > 0) {
                factors.add(new int[]{prime, count});
            }
        }
        if (number > 1) {
            factors.add(new int[]{number, 1});
        }
        return factors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        findS();

        int test = sc.nextInt();
        while (test-- > 0) {
            int upN = sc.nextInt();
            int upM = sc.nextInt();

            // Find largest prime <= n
            int lastPrime = 0;
            for (int i = upN; i >= 2; i--) {
                if (isPrime[i]) {
                    lastPrime = i;
                    break;
                }
            }

            if (lastPrime == 0) {
                System.out.println(0);
                continue;
            }

            int startY = lastPrime + 1;
            int rlen = upN - lastPrime;
            if (rlen <= 0) {
                System.out.println(0);
                continue;
            }

            List<List<int[]>> facLis = new ArrayList<>();
            Set<Integer> uniquePrimes = new HashSet<>();

            for (int i = 0; i < rlen; i++) {
                int number = startY + i;
                List<int[]> factors = primeFactorize(number);
                facLis.add(factors);
                for (int[] factor : factors) {
                    uniquePrimes.add(factor[0]);
                }
            }

            List<Integer> primeList = new ArrayList<>(uniquePrimes);
            int numPrimes = primeList.size();

            long[] pSum = new long[numPrimes];
            for (int i = 0; i < numPrimes; i++) {
                int prime = primeList.get(i);
                long total = 0, power = prime;
                while (power <= upN) {
                    total += upN / power;
                    if (power > upN / prime) break;
                    power *= prime;
                }
                pSum[i] = total;
            }

            long[][] suffixS = new long[numPrimes][rlen + 1];
            for (int i = 0; i < numPrimes; i++) {
                int prime = primeList.get(i);
                for (int j = rlen - 1; j >= 0; j--) {
                    long exp = 0;
                    for (int[] factor : facLis.get(j)) {
                        if (factor[0] == prime) {
                            exp = factor[1];
                            break;
                        }
                    }
                    suffixS[i][j] = suffixS[i][j + 1] + exp;
                }
            }

            long tA = 0;
            for (int x = 0; x < rlen; x++) {
                long minValue = Long.MAX_VALUE / 4;
                for (int i = 0; i < numPrimes; i++) {
                    long suffixValue = suffixS[i][x];
                    if (suffixValue == 0) continue;

                    long vx = pSum[i] - suffixValue;
                    int prime = primeList.get(i);

                    int maxexp = 0;
                    long power = 1;
                    while (prime <= upM / power) {
                        power *= prime;
                        if (power > upM) break;
                        maxexp++;
                    }

                    for (int e = maxexp; e >= 1; e--) {
                        long remainder = vx % e;
                        long needed = (remainder == 0) ? e : e - remainder;
                        if (suffixValue >= needed) {
                            long sp = vx / e;
                            minValue = Math.min(minValue, sp);
                            break;
                        }
                    }
                }
                tA += minValue;
            }

            System.out.println(tA);
        }
    }
}
