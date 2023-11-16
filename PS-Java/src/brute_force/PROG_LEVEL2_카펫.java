package brute_force;

public class PROG_LEVEL2_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int width = i;
                int height = yellow / i;

                int temp = (width + 2) * 2 + 2 * height;
                if (temp == brown) {
                    answer[1] = width + 2;
                    answer[0] = height + 2;
                    return answer;
                }
            }
        }
        return answer;
    }
}
