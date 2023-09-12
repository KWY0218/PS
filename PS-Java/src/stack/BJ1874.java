package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class BJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = parseInt(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = parseInt(br.readLine());
        }

        Stack<String> answer = new Stack<>();
        int[] arr = IntStream.range(1, n + 1).toArray();
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            stack.push(arr[i]);
            answer.push("+");
            while (!stack.isEmpty() && num[count] == stack.peek()) {
                stack.pop();
                answer.push("-");
                count++;
            }
        }

        if (stack.isEmpty()) answer.forEach(System.out::println);
        else System.out.println("NO");
    }
}
