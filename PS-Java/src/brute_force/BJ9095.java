package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class BJ9095 {
    private static int answer = 0;
    private static int[] ints = {1, 2, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = parseInt(br.readLine());
        int[] temp;
        for (int i = 0; i < t; i++) {
            int n = parseInt(br.readLine());
            answer = 0;
            for (int s = 1; s <= n; s++) {
                temp = new int[s];
                solve(temp, 0, s, n);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int[] temp, int deps, int height, int n) {
        if (deps == height) {
            if (Arrays.stream(temp).sum() == n) answer++;
            return;
        }
        for (int i : ints) {
            temp[deps] = i;
            solve(temp, deps + 1, height, n);
        }
    }
}
