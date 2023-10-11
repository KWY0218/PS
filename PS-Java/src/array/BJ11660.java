package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11660 {
    /*
     * 1초 : 100,000,000
     * n^2 = 1024 * 1024 = 1,048,576 (o)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sumArr = new int[n + 1][n + 1];
        sumArr[1][1] = arr[1][1];
        for (int j = 1; j <= n; j++) {
            sumArr[1][j] = sumArr[1][j - 1] + arr[1][j];
            sumArr[j][1] = sumArr[j - 1][1] + arr[j][1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                sumArr[j][i] = arr[j][i] + sumArr[j - 1][i] + sumArr[j][i - 1] - sumArr[j - 1][i - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer = sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
