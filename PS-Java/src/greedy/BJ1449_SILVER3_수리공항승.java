package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1449_SILVER3_수리공항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        if (l == 1 || nums.length == 1) System.out.println(nums.length);
        else {
            Arrays.sort(nums);

            int count = 1;
            double num = nums[0] - 0.5 + l;
            for (int i = 1; i < n; i++) {
                if (num > nums[i]) continue;
                num = nums[i] - 0.5 + l;
                count++;
            }
            System.out.println(count);
        }
    }
}
