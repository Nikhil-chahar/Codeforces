package codeforces;

import java.util.*;
public class capping {
    static final int MAX_N = 90000000;
    static boolean[] isPrime;
    static Set<Integer> semiPrimes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        preprocess(MAX_N);

        StringBuilder output = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            Map<Integer, Integer> freq = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
            }
            
            output.append(countSemiPrimePairs(freq)).append("\n");
        }
        
        System.out.print(output);
        sc.close();
    }

    static void preprocess(int max) {
        isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        semiPrimes = new HashSet<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i; j * i <= max; j++) {
                    if (isPrime[j]) {
                        semiPrimes.add(i * j);
                    }
                }
            }
        }
    }

    static int countSemiPrimePairs(Map<Integer, Integer> freq) {
        int count = 0;
        List<Integer> keys = new ArrayList<>(freq.keySet());
        int size = keys.size();
        
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int x = keys.get(i);
                int y = keys.get(j);
                int lcmValue = lcm(x, y);
                
                if (semiPrimes.contains(lcmValue)) {
                    if (i == j) {
                        count += (freq.get(x) * (freq.get(x) + 1)) / 2;
                    } else {
                        count += freq.get(x) * freq.get(y);
                    }
                }
            }
        }
        return count;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
