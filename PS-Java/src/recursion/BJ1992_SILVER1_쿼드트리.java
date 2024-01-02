package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1992_SILVER1_쿼드트리 {
    private static int[][] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n][];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            nums[i] = Arrays.stream(str.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        StringBuilder sb = new StringBuilder();
        tree(0, n, 0, n, sb);
        System.out.println(sb);
    }

    public static void tree(int sr, int er, int sc, int ec, StringBuilder sb) {
        int result = treeSum(sr, er, sc, ec);
        if (!(result < 0)) {
            sb.append(result);
            return;
        }
        int sm = (sr + er) / 2;
        int cm = (sc + ec) / 2;
        sb.append("(");
        tree(sr, sm, sc, cm, sb);
        tree(sr, sm, cm, ec, sb);
        tree(sm, er, sc, cm, sb);
        tree(sm, er, cm, ec, sb);
        sb.append(")");
    }

    public static int treeSum(int sr, int er, int sc, int ec) {
        int temp = 0;
        for (int i = sr; i < er; i++) {
            for (int j = sc; j < ec; j++) {
                temp += nums[i][j];
            }
        }

        int len = er - sr;
        if (temp == len * len) return 1;
        else if (temp == 0) return 0;
        else return -1;
    }
}
