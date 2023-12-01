package hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PROG_LEVEL2_오픈채팅방 {

    class Solution {
        public String[] solution(String[] record) {
            Queue<State> history = new LinkedList<>();
            HashMap<String, String> name = new HashMap<>();

            for (String r : record) {
                StringTokenizer st = new StringTokenizer(r);
                String state = st.nextToken();
                String uid = st.nextToken();
                String nickName = "";
                if (!state.equals("Leave")) nickName = st.nextToken();

                if (state.equals("Enter")) name.put(uid, nickName);
                if (state.equals("Change")) name.put(uid, nickName);
                else history.add(new State(uid, state));
            }

            String[] answer = new String[history.size()];
            int count = 0;
            while (!history.isEmpty()) {
                State state = history.poll();
                String nickName = name.get(state.uid);

                answer[count++] = state.getResult(nickName);
            }

            return answer;
        }
    }

    class State {
        String uid;
        String state;

        State(String uid, String state) {
            this.uid = uid;
            this.state = state;
        }

        public String getResult(final String nickName) {
            if (state.equals("Enter")) return nickName + "님이 들어왔습니다.";
            else return nickName + "님이 나갔습니다.";
        }
    }

}
