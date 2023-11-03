package divide;

public class PROG_LEVEL2_쿼드압축후개수세기 {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int[] answer = solution(arr);
        int[][] arr2 = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };
        int[] answer2 = solution(arr2);
    }

    public static int[] solution(int[][] arr) {
        int zeroCount = div(arr, 0, arr.length, 0, arr.length, 0);
        int oneCount = div(arr, 0, arr.length, 0, arr.length, 1);
        return new int[]{zeroCount, oneCount};
    }

    private static int div(int[][] arr, int rowStart, int rowEnd, int colStart, int colEnd, int target) {
        if (rowEnd - rowStart <= 1) {
            if (arr[rowStart][colStart] == target) return 1;
            else return 0;
        }
        boolean isQuad = true;
        for (int r = rowStart; r < rowEnd; r++) {
            for (int c = colStart; c < colEnd; c++) {
                if (arr[r][c] != target) {
                    isQuad = false;
                    break;
                }
            }
            if (!isQuad) break;
        }
        System.out.println();
        if (isQuad) return 1;

        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (colStart + colEnd) / 2;

        int c1 = div(arr, rowStart, rowMid, colStart, colMid, target);
        int c2 = div(arr, rowMid, rowEnd, colStart, colMid, target);
        int c3 = div(arr, rowStart, rowMid, colMid, colEnd, target);
        int c4 = div(arr, rowMid, rowEnd, colMid, colEnd, target);

        return c1 + c2 + c3 + c4;
    }
}
