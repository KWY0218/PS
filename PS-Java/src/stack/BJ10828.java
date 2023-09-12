package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class BJ10828 {
    public static void main(String[] args) throws IOException {
        Stack stack = new Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] order = br.readLine().split(" ");
            switch (order[0]) {
                case "push":
                    stack.push(parseInt(order[1]));
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
            }
        }
    }

    public static class Stack {
        private int[] arr = new int[10001];
        private int size = 0;

        public void push(int x) {
            arr[size++] = x;
        }

        public int pop() {
            return size == 0 ? -1 : arr[--size];
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public int top() {
            return size == 0 ? -1 : arr[size - 1];
        }
    }
}
