package greedy;

import java.util.Arrays;

public class BJ4673_Silver5_셀프넘버 {
    public static void main(String[] args) {
        boolean[] nums = new boolean[10_001];
        for (int i = 1; i <= 10_000; i++) {
            int num = i;
            num += Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
            if(num <= 10_000) nums[num] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10_000; i++) {
            if(!nums[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
