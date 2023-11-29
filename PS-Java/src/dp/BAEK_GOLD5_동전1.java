package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_GOLD5_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[k + 1];
        nums[0] = 1;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            for (int j = num; j <= k; j++) {
                nums[j] = nums[j] + nums[j - num];
            }
        }

        System.out.println(nums[k]);
    }
}
