package hash;

import java.util.HashMap;

public class PROG_LEVEL2_할인행사 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        solution(want, number, discount);
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            String dis = discount[i];
            if (!map.containsKey(dis)) continue;

            int count = map.get(dis);
            map.put(dis, count - 1);
        }

        int answer = 0;

        boolean isAns = true;
        for (int c : map.values()) {
            if (c > 0) {
                isAns = false;
                break;
            }
        }
        if (isAns) answer++;


        for (int i = 10; i < discount.length; i++) {
            String nextDis = discount[i];
            String prevDis = discount[i - 10];
            if (map.containsKey(nextDis)) map.put(nextDis, map.get(nextDis) - 1);
            if (map.containsKey(prevDis)) map.put(prevDis, map.get(prevDis) + 1);

            isAns = true;
            for (int c : map.values()) {
                if (c > 0) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) answer++;
        }

        return answer;
    }
}
