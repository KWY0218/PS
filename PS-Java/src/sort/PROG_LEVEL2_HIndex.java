package sort;

import java.util.Arrays;
import java.util.Collections;

public class PROG_LEVEL2_HIndex {
    public int solution(int[] citations) {
        Integer[] c = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(c, Collections.reverseOrder());
        int size = citations.length;
        for (int i = 0; i < citations.length; i++) {
            int h = c[i];
            if (i + 1 > h) {
                return i;
            }
        }
        return size;
    }
}
