package sort;

import java.util.Arrays;
import java.util.Collections;

public class PROG_LEVEL2_최솟값만들기 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);

        // 스트림 이용 시 시간 초과
        // Integer[] b = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Integer[] b = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            b[i] = B[i];
        }
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * b[i];
        }

        return answer;
    }

    public int solution2(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }

        return answer;
    }
}
