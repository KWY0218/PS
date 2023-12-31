package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1339_GOLD4_단어수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }

        int[] nums = new int[26];
        for (String str : strs) {
            int num = 1;
            for (int i = 1; i <= str.length(); i++) {
                char c = str.charAt(str.length() - i);
                nums[c - 'A'] += num;
                num *= 10;
            }
        }

        Arrays.sort(nums);
        int answer = 0;
        int num = 9;
        int idx = 25;
        while (nums[idx] != 0) {
            answer += (nums[idx--] * num--);
        }
        System.out.println(answer);
    }
}
