package math;

public class PROF_LEVEL2_점프와순간이동 {

    public class Solution {

        public int solution(int n) {
            int answer = 0;
            while (n != 0) {
                if (n % 2 != 0) answer++;
                n /= 2;
            }

            return answer;
        }
    }
}
