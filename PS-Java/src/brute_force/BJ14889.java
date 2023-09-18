package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

public class BJ14889 {
    private static boolean[] visited;
    private static int[][] team;
    private static int n;
    private static int answer = MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        visited = new boolean[n];

        team = new int[n][];
        for (int i = 0; i < n; i++) {
            team[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        searchTeam(0, 0);
        System.out.println(answer);
    }

    private static void searchTeam(int next, int deps) {
        if (deps == n / 2) {
            int[] start = new int[n / 2];
            int[] link = new int[n / 2];
            int startIdx = 0;
            int linkIdx = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) start[startIdx++] = i;
                else link[linkIdx++] = i;
            }
            answer = Math.min(Math.abs(calScore(start) - calScore(link)), answer);
            return;
        }
        for (int i = next; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                searchTeam(i + 1, deps + 1);
                visited[i] = false;
            }
        }
    }

    private static int calScore(int[] temp) {
        int score = 0;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n / 2; j++) {
                score += team[temp[i]][temp[j]];
                score += team[temp[j]][temp[i]];
            }
        }
        return score;
    }
}
