package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11403_경로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int e = 1; e <= n; e++) {
                int next = Integer.parseInt(st.nextToken());
                if (next == 0) graph[i][e] = 10000;
                else graph[i][e] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    graph[s][e] = Math.min(graph[s][e], graph[s][i] + graph[i][e]);
                }
            }
        }

        for (int s = 1; s <= n; s++) {
            for (int e = 1; e <= n; e++) {
                if (graph[s][e] == 10000) System.out.print("0 ");
                else System.out.print("1 ");
            }
            System.out.println();
        }
    }
}
