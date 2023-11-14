package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1956_운동 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maps = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n; s++) {
                maps[i][s] = 10_000_000;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            maps[a][b] = c;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    maps[s][e] = Math.min(maps[s][e], maps[s][i] + maps[i][e]);
                }
            }
        }

        int answer = 10_000_000;
        for (int s = 1; s <= n; s++) {
            for (int e = 1; e <= n; e++) {
                if (s == e) continue;
                if (maps[s][e] != 10_000_000 && maps[e][s] != 10_000_000) {
                    answer = Math.min(answer, maps[s][e] + maps[e][s]);
                }
            }
        }

        if (answer == 10_000_000) System.out.println(-1);
        else System.out.println(answer);
    }
}
