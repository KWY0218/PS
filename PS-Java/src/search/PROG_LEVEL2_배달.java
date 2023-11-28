package search;

public class PROG_LEVEL2_배달 {
    public int solution(int N, int[][] road, int K) {
        int[][] maps = new int[N + 1][N + 1];

        for (int s = 1; s <= N; s++) {
            for (int e = 1; e <= N; e++) {
                if (s == e) continue;
                maps[s][e] = 10_000_000;
            }
        }

        for (int[] r : road) {
            int s = r[0];
            int e = r[1];
            int w = r[2];
            if (maps[s][e] != 10_000_000 && maps[s][e] < w) continue;
            maps[s][e] = w;
            maps[e][s] = w;
        }


        for (int i = 1; i <= N; i++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    maps[s][e] = Math.min(maps[s][e], maps[s][i] + maps[i][e]);
                }
            }
        }

        int answer = 0;
        for (int s = 1; s <= N; s++) {
            if (maps[1][s] <= K) answer++;
        }

        return answer;

    }
}
