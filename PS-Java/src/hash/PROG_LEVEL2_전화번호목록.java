package hash;

import java.util.Arrays;
import java.util.HashMap;

public class PROG_LEVEL2_전화번호목록 {

    class Solution {
        /*
         * Solution 2
         * 해시 사용
         * */
        public boolean solution2(String[] phone_book) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (String phone : phone_book) {
                hashMap.put(phone, 1);
            }
            for (int i = 0; i < phone_book.length; i++) {
                for (int j = 1; j < phone_book[i].length(); j++) {
                    if (hashMap.containsKey(phone_book[i].substring(0, j))) return false;
                }
            }
            return true;
        }

        /*
         * Solution 1
         * startsWith 함수 사용한 풀이
         * 문자열을 정렬하면 사전 순으로 정렬되기 때문에
         * i 가 i+1 에 해당하는 문자열엔 포함될 순 있지만
         * i+2에는 포함될 수 없다.
         * */
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);
            for (int i = 0; i < phone_book.length - 1; i++) {
                if (phone_book[i + 1].startsWith(phone_book[i])) return false;
            }
            return true;
        }
    }
}
