package implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PROG_LEVEL2_주차요금계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees, records);

        int[] fees2 = {120, 0, 60, 591};
        String[] records2 = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        solution(fees2, records2);

        int[] fees3 = {1, 461, 1, 10};
        String[] records3 = {"00:00 1234 IN"};
        solution(fees3, records3);
    }

    public static int[] solution(int[] fees, String[] records) {
        HashMap<String, Record> place = new HashMap<>();

        // record 계산
        for (String record : records) {
            String[] r = record.split(" ");
            if (r[2].equals("IN")) {
                if (place.containsKey(r[1])) {
                    Record rec = place.get(r[1]);
                    rec.startTime = r[0];
                } else place.put(r[1], new Record(r[1], r[0]));
            } else {
                Record rec = place.get(r[1]);
                String endTime = r[0];
                rec.calculate(endTime);

                rec.startTime = null;
            }
        }

        // 출차 되지 않는 차 계산
        for (Record record : place.values()) {
            if (record.startTime != null) {
                record.calculate("23:59");
            }
        }

        // 숫자판 크기가 작은 순서대로 배열에 삽입
        List<Record> recordList = new ArrayList<>(place.values()).stream()
                .sorted()
                .collect(Collectors.toList());

        int[] answer = new int[recordList.size()];
        for (int i = 0; i < recordList.size(); i++) {
            answer[i] = getMoney(recordList.get(i).minute, fees[0], fees[1], fees[2], fees[3]);
        }
        return answer;
    }

    private static int getMoney(int minute, int basicTime, int basicMoney, int unitTime, int unitMoney) {
        int diff = minute - basicTime;
        if (diff <= 0) return basicMoney;

        int money = basicMoney;
        if (diff % unitTime != 0) diff = diff - diff % unitTime + unitTime;
        return money + (diff / unitTime) * unitMoney;
    }
}

class Record implements Comparable<Record> {
    String number;
    String startTime;
    int minute;

    public Record(String number, String startTime) {
        this.number = number;
        this.startTime = startTime;
        minute = 0;
    }

    public void calculate(String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");

        int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
        int min = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);

        minute += (hour * 60 + min);
    }

    @Override
    public int compareTo(Record o) {
        return Integer.parseInt(number) - Integer.parseInt(o.number);
    }
}

