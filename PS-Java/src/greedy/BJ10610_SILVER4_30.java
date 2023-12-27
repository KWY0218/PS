package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ10610_SILVER4_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split("");

        int sumNums = 0;
        boolean isZero = false;
        for (String n : nums) {
            sumNums += Integer.parseInt(n);
            if (n.equals("0")) isZero = true;
        }
        if (sumNums % 3 != 0 || !isZero) System.out.println("-1");
        else {
            Arrays.sort(nums, Comparator.reverseOrder());
            System.out.println(String.join("", nums));
        }
    }
}
