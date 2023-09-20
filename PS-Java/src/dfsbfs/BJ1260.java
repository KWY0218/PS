package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BJ1260 {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int v = parseInt(st.nextToken());

        graph = new ArrayList<>() {
            {
                for (int i = 0; i < n + 1; i++) {
                    add(new ArrayList<>());
                }
            }
        };

        for (int i = 0; i < m; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(nums[0]).add(nums[1]);
            graph.get(nums[1]).add(nums[0]);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");

        visited = new boolean[n + 1];
        visited[v] = true;
        sb.append(v).append(" ");
        bfs(v);
        sb.append("\n");

        System.out.println(sb);
    }

    private static void dfs(int idx) {
        sb.append(idx).append(" ");
        visited[idx] = true;
        for (int g : graph.get(idx)) {
            if (!visited[g]) {
                dfs(g);
            }
        }
    }

    private static void bfs(int idx) {
        Queue<Integer> que = new LinkedList<>() {
            {
                add(idx);
            }
        };
        while (!que.isEmpty()) {
            int q = que.poll();
            for (int g : graph.get(q)) {
                if (!visited[g]) {
                    sb.append(g).append(" ");
                    visited[g] = true;
                    que.add(g);
                }
            }
        }
    }
}
