package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463_Silver4_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        if (x == 1) System.out.println(0);
        else if (x == 2) System.out.println(1);
        else {
            int[] nums = new int[x + 1];
            nums[2] = 1;

            for (int i = 3; i <= x; i++) {
                if (i % 2 == 0 && i % 3 == 0) {
                    int min = Math.min(nums[i / 2], nums[i / 3]);
                    nums[i] = Math.min(min, nums[i - 1]);
                } else if (i % 2 == 0) nums[i] = Math.min(nums[i / 2], nums[i - 1]);
                else if (i % 3 == 0) nums[i] = Math.min(nums[i / 3], nums[i - 1]);
                else nums[i] = nums[i - 1];
                nums[i] += 1;
            }

            System.out.println(nums[x]);
        }
    }
}
