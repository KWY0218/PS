package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1976 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) union(i, j);
            }
        }

        boolean answer = true;

        int[] cities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int cityValue = find(cities[0]);
        for (int i = 1; i < cities.length; i++) {
            if (cityValue != find(cities[i])) {
                answer = false;
                break;
            }
        }

        if (answer) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int num) {
        if (parent[num] != num) {
            return parent[num] = find(parent[num]);
        }
        return num;
    }
}
