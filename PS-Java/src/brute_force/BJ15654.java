package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BJ15654 {
    private static int[] nums;
    private static int[] ans;
    private static int n;
    private static int m;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = parseInt(st.nextToken());
        n = parseInt(st.nextToken());

        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        ans = new int[n];
        visited = new boolean[m];
        solve(0);
        System.out.println(sb.toString());
    }

    private static void solve(int deps) {
        if (deps == n) {
            for (int a : ans) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[deps] = nums[i];
                solve(deps + 1);
                visited[i] = false;
            }
        }
    }
}
