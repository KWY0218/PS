package brute_force;

public class PROG_LEVEL2_삼각달팽이 {
    public int[] solution(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }

        int value = 1;
        int col = -1;
        int row = 0;
        for (int i = n; i > 0; i -= 3) {
            for (int j = 0; j < i; j++) {
                triangle[++col][row] = value++;
            }
            for (int j = 0; j < i - 1; j++) {
                triangle[col][++row] = value++;
            }
            for (int j = 0; j < i - 2; j++) {
                triangle[--col][--row] = value++;
            }

        }
        int[] answer = new int[(n * (n + 1)) / 2];
        int index = 0;
        for (int[] tri : triangle) {
            for (int t : tri) {
                answer[index++] = t;
            }
        }
        return answer;
    }
}
