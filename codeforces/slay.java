package codeforces;

import java.util.*;
public class slay {
    static List<Integer>[] tree;
    static int[] values;
    static int[] result;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        StringBuilder output = new StringBuilder();

        while (t-- > 0) {
            n = sc.nextInt();
            values = new int[n + 1];
            tree = new ArrayList[n + 1];
            result = new int[n + 1];
            
            for (int i = 1; i <= n; i++) {
                values[i] = sc.nextInt();
                tree[i] = new ArrayList<>();
            }

            for (int i = 1; i < n; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                tree[u].add(v);
                tree[v].add(u);
            }
            
            dfs(1, -1, new HashMap<>());
            
            for (int i = 1; i <= n; i++) {
                output.append(result[i]);
            }
            output.append("\n");
        }
        
        System.out.print(output);
        sc.close();
    }

    static void dfs(int node, int parent, Map<Integer, Integer> freq) {
        freq.put(values[node], freq.getOrDefault(values[node], 0) + 1);
        
        int majority = -1, maxCount = 0;
        int totalNodes = freq.values().stream().mapToInt(Integer::intValue).sum();
        
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > totalNodes / 2) {
                majority = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        
        if (majority == values[node]) result[node] = 1;
        
        for (int neighbor : tree[node]) {
            if (neighbor == parent) continue;
            dfs(neighbor, node, new HashMap<>(freq));
        }
    }
}
