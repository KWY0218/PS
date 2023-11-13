package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2458_키순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
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
                if (graph[s][e] || graph[e][s]) {
                    count[s]++;
                }
            }
        }

        int answer = 0;
        for (int c : count) {
            if (c == n - 1) answer++;
        }
        System.out.println(answer);
    }
}
