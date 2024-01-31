package divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074_SILVER1_Z {
    private static int targetRow;
    private static int targetCol;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        targetRow = Integer.parseInt(st.nextToken());
        targetCol = Integer.parseInt(st.nextToken());

        int end = (int) Math.pow(2, n);
        divide(0, end, 0, end);
        System.out.println(answer);
    }

    private static void divide(int startRow, int endRow, int startCol, int endCol) {
        if (startRow == targetRow && startCol == targetCol) return;

        int midRow = (startRow + endRow) / 2;
        int midCol = (startCol + endCol) / 2;
        int size = (endRow - startRow) / 2;
        int num = (int) Math.pow(size, 2);

        if (targetRow >= startRow && targetRow < midRow && targetCol >= startCol && targetCol < midCol) {
            divide(startRow, midRow, startCol, midCol);
        } else if (targetRow >= startRow && targetRow < midRow && targetCol >= midCol && targetCol < endCol) {
            divide(startRow, midRow, midCol, endCol);
            answer += num;
        } else if (targetRow >= midRow && targetRow < endRow && targetCol >= startCol && targetCol < midCol) {
            divide(midRow, endRow, startCol, midCol);
            answer += (2 * num);
        } else if (targetRow >= midRow && targetRow < endRow && targetCol >= midCol && targetCol < endCol) {
            divide(midRow, endRow, midCol, endCol);
            answer += (3 * num);
        }
    }
}
