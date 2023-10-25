package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PROG_LEVEL2_튜플 {
    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        solution("{{20,111},{111}}");
        solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
        otherSolution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        otherSolution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        otherSolution("{{20,111},{111}}");
        otherSolution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }

    /*
     * s.replaceAll("[{]", " ").replaceAll("[}]", " ") -> "  2 , 2,1 , 2,1,3 , 2,1,3,4  "
     * s.trim() -> "2 , 2,1 , 2,1,3 , 2,1,3,4"
     * s.split(" , ") ->  ["2", "2,1", "2,1,3", "2,1,3,4"]
     *
     * */
    public static int[] otherSolution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });
        int[] answer = new int[arr.length];
        int idx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

    public static int[] solution(String s) {
        List<List<Integer>> temp = new ArrayList<>();
        int index = 1;
        while (index < s.length() - 1) {
            if (s.charAt(index++) == '{') {
                List<Integer> tuple = new ArrayList<>();
                StringBuilder str = new StringBuilder();
                while (true) {
                    if (s.charAt(index) == ',') {
                        tuple.add(Integer.parseInt(str.toString()));
                        str = new StringBuilder();
                    } else if (s.charAt(index) == '}') {
                        tuple.add(Integer.parseInt(str.toString()));
                        break;
                    } else str.append(s.charAt(index));
                    index++;
                }
                temp.add(tuple);
            }
        }
        temp = temp.stream().sorted(Comparator.comparingInt(List::size)).collect(Collectors.toList());
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (List<Integer> t : temp) {
            set.addAll(t);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
