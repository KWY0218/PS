package dp;

import java.util.HashSet;

public class PROG_LEVEL2_연속부분수열합의개수 {
    public static void main(String[] args) {
        int[] ele = {7, 9, 1, 1, 4};
        System.out.println(solution(ele));
    }

    public static int solution(int[] elements) {
        HashSet<Integer> answer = new HashSet<>();
        int[] temp = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                temp[j] += elements[(j + i) % elements.length];
                answer.add(temp[j]);
            }
        }
        return answer.size();
    }
}
