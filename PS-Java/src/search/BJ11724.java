package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ11724 {
    private static boolean[] visited;
    private static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        while (true) {
            int next = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) next = i;
            }
            if (next == -1) break;

            answer++;
            visited[next] = true;
            stack.addAll(graph.get(next));

            while (!stack.isEmpty()) {
                int s = stack.pop();
                if (!visited[s]) {
                    for (int g : graph.get(s)) {
                        if (!visited[g]) stack.add(g);
                    }
                    visited[s] = true;
                }
            }
        }
        System.out.println(answer);
    }
}
