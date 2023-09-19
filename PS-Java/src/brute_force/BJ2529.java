package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class BJ2529 {
    private static int[] temp;
    private static int n;
    private static boolean[] visited = new boolean[10];
    private static List<String> k;
    private static String min;
    private static String max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        temp = new int[n + 1];
        k = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            temp[0] = i;
            solve(1, 0);
            visited[i] = false;
        }

        System.out.println(max + "\n" + min);
    }

    private static void solve(int deps, int next) {
        if (deps == n + 1) {
            String s = Arrays.stream(temp).mapToObj(Integer::toString).collect(Collectors.joining());
            if (min == null) min = s;
            else max = s;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if (!compare(k.get(next), temp[deps - 1], i)) continue;
                visited[i] = true;
                temp[deps] = i;
                solve(deps + 1, next + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean compare(String s, int n1, int n2) {
        if (s.equals(">")) return n1 > n2;
        else return n1 < n2;
    }
}
