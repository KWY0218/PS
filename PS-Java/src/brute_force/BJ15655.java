package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BJ15655 {
    private static int n;
    private static int m;
    private static int[] nums;
    private static boolean[] visited;
    private static int[] arr;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        visited = new boolean[n];
        arr = new int[m];

        solve(0, 0);

        System.out.println(sb);
    }

    private static void solve(int next, int deps) {
        if (deps == m) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = next; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[deps] = nums[i];
                solve(i + 1, deps + 1);
                visited[i] = false;
            }
        }
    }
}
