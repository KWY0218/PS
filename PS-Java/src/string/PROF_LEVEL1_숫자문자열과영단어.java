package string;

public class PROF_LEVEL1_숫자문자열과영단어 {
    class Solution {
        public int solution(String s) {
            String[] strs = {"zero", "one", "two","three","four","five","six","seven","eight","nine"};
            for(int i = 0 ; i<strs.length ; i++) {
                if(s.contains(strs[i])) s= s.replaceAll(strs[i], i+"");
            }
            return Integer.parseInt(s);
        }
    }
}
