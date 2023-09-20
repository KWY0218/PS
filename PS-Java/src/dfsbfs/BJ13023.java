package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ13023 {
    private static int n;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];

        graph = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) {
                    add(new ArrayList<>());
                }
            }
        };

        for (int i = 0; i < nm[1]; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(nums[0]).add(nums[1]);
            graph.get(nums[1]).add(nums[0]);
        }

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1);
            if (answer == 1) break;
            visited[i] = false;
        }
        System.out.println(answer);
    }

    private static void dfs(int next, int deps) {
        if (deps == 5) {
            answer = 1;
            return;
        }

        for (int g : graph.get(next)) {
            if (!visited[g]) {
                visited[g] = true;
                dfs(g, deps + 1);
                visited[g] = false;
            }
        }
    }
}
