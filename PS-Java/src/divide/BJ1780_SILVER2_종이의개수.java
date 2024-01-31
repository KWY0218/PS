package divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780_SILVER2_종이의개수 {
    private static int[][] nums;
    private static int[] targets = {-1, 0, 1};
    private static int[] answers = {0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            nums[i] = temp;
        }

        divide(0, n, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int a : answers) sb.append(a).append("\n");
        System.out.println(sb);
    }

    private static void divide(int startRow, int endRow, int startCol, int endCol) {
        if (endRow - startRow == 3) {
            for (int i = 0; i < 3; i++) {
                if (!check(startRow, endRow, startCol, endCol, targets[i])) continue;
                answers[i]++;
                return;
            }

            for (int r = startRow; r < endRow; r++) {
                for (int c = startCol; c < endCol; c++) {
                    if (nums[r][c] == -1) answers[0]++;
                    else if (nums[r][c] == 0) answers[1]++;
                    else if (nums[r][c] == 1) answers[2]++;
                }
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!check(startRow, endRow, startCol, endCol, targets[i])) continue;
            answers[i]++;
            return;
        }

        int div = (endRow - startRow) / 3;
        int firstRow = startRow + div;
        int firstCol = startCol + div;
        int secondRow = firstRow + div;
        int secondCol = firstCol + div;

        divide(startRow, firstRow, startCol, firstCol);
        divide(firstRow, secondRow, startCol, firstCol);
        divide(secondRow, endRow, startCol, firstCol);

        divide(startRow, firstRow, firstCol, secondCol);
        divide(firstRow, secondRow, firstCol, secondCol);
        divide(secondRow, endRow, firstCol, secondCol);

        divide(startRow, firstRow, secondCol, endCol);
        divide(firstRow, secondRow, secondCol, endCol);
        divide(secondRow, endRow, secondCol, endCol);
    }

    private static boolean check(int startRow, int endRow, int startCol, int endCol, int target) {
        for (int r = startRow; r < endRow; r++) {
            for (int c = startCol; c < endCol; c++) {
                if (nums[r][c] != target) return false;
            }
        }
        return true;
    }
}
