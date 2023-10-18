package dp;

public class PROG_LEVEL3_정수삼각형 {
    private int[][] max;
    private int answer = 0;

    public int solution(int[][] triangle) {
        max = new int[triangle.length][];
        max[0] = triangle[0];
        for (int i = 1; i < triangle.length; i++) {
            max[i] = new int[i + 1];
        }
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    max[i][j] = triangle[i][j] + max[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    max[i][j] = triangle[i][j] + max[i - 1][j - 1];
                } else {
                    max[i][j] = Math.max(triangle[i][j] + max[i - 1][j - 1], triangle[i][j] + max[i - 1][j]);
                }
            }
        }
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(max[triangle.length - 1][i], answer);
        }
        return answer;
    }

//    /*
//     * dfs 풀이
//     * -> 시간 초과
//     * */
//
//    public int solution1(int[][] triangle) {
//        dfs(triangle, 0, 0, 0);
//        return answer;
//    }
//
//    public void dfs(int[][] triangle, int height, int width, int sum) {
//        if (height == triangle.length) {
//            if (answer < sum) answer = sum;
//            return;
//        }
//        dfs(triangle, height + 1, width, sum + triangle[height][width]);
//        dfs(triangle, height + 1, width + 1, sum + triangle[height][width]);
//    }
}
