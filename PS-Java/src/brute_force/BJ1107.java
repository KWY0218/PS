package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class BJ1107 {
    private static boolean[] visited = new boolean[10];
    private static int[] temp;
    private static int size;
    private static int n;
    private static int minNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        int m = parseInt(br.readLine());

        if (m != 0) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int num : nums) {
                visited[num] = true;
            }
        }

        minNum = Math.abs(100 - n);
        if (minNum == 0) System.out.println("0");
        else {
            // 목표 채널과 이동 할 채널의 자리 수가 같을 때
            size = Integer.toString(n).length();
            temp = new int[size];
            solve(0);
            // 이동 할 채널의 자리 수가 목표 채널 보다 한자리 수 높을 경우
            size = Integer.toString(n).length() + 1;
            temp = new int[size];
            solve(0);
            // 이동 할 채널의 자리 수가 목표 채널 보다 한자리 수 낮을 경우
            // 이 때 목표 채널이 한자리 수일 때에는 해당 구문을 스킵한다.
            size = Integer.toString(n).length() - 1;
            if (size != 0) {
                temp = new int[size];
                solve(0);
            }
            System.out.println(minNum);
        }
    }

    public static void solve(int deps) {
        if (deps == size) {
            int result = 0;
            for (int t : temp) {
                result = result * 10 + t;
            }
            int t = Integer.toString(result).length() + Math.abs(n - result);
            minNum = Math.min(minNum, t);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                temp[deps] = i;
                solve(deps + 1);
            }
        }
    }
}
