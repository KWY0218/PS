package search;

public class PROG_LEVEL3_순위 {
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int[] r : results) {
            graph[r[1]][r[0]] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (graph[s][i] && graph[i][e]) graph[s][e] = true;
                }
            }
        }
        int[] count = new int[n + 1];
        for (int s = 1; s <= n; s++) {
            for (int e = 1; e <= n; e++) {
                if (graph[s][e] || graph[e][s]) count[s]++;
            }
        }

        int answer = 0;
        for (int c : count) {
            if (c == n - 1) answer++;
        }
        return answer;
    }
}
