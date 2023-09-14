package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class BJ3085 {
    private static int n;
    private static int[][] move = {{1, 0}, {0, 1}};
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        arr = new char[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int ans = read(arr);

        if (ans != n) {
            boolean isEnd = false;
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    int re = change(col, row);
                    if (re == n) {
                        ans = n;
                        isEnd = true;
                    } else {
                        ans = Math.max(ans, re);
                    }
                }
                if (isEnd) break;
            }
        }

        System.out.println(ans);
    }

    private static int change(int col, int row) {
        int re = -1;
        for (int m = 0; m < move.length; m++) {
            int c = col + move[m][0];
            int r = row + move[m][1];
            if (c > 0 && c < n && r > 0 && r < n) {
                char temp = arr[col][row];
                arr[col][row] = arr[c][r];
                arr[c][r] = temp;
                re = Math.max(read(arr), re);
                arr[c][r] = arr[col][row];
                arr[col][row] = temp;
            }
        }
        return re;
    }

    private static int read(char[][] arr) {
        int max = -1;
        for (int col = 0; col < n; col++) {
            int cnt = 1;
            for (int row = 1; row < n; row++) {
                if (arr[col][row] == arr[col][row - 1]) cnt++;
                else cnt = 1;
                max = Math.max(max, cnt);
            }
        }

        for (int row = 0; row < n; row++) {
            int cnt = 1;
            for (int col = 1; col < n; col++) {
                if (arr[col][row] == arr[col - 1][row]) cnt++;
                else cnt = 1;
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
