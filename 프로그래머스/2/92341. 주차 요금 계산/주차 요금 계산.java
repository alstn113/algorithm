import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> ins = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();
        for (String r : records) {
            String[] split = r.split(" ");
            int time = getTime(split[0]);
            String number = split[1];
            String action = split[2];

            if (action.equals("IN")) {
                ins.put(number, time);
            } else {
                int inTime = ins.get(number);
                sum.put(number, sum.getOrDefault(number, 0) + time - inTime);
                ins.remove(number);
            }
        }
        int lastTime = getTime("23:59");
        for (Map.Entry<String, Integer> entry : ins.entrySet()) {
            String number = entry.getKey();
            int inTime =  entry.getValue();
            sum.put(number, sum.getOrDefault(number, 0) + lastTime - inTime);
        }

        int dTime = fees[0];
        int dFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sum.entrySet()) {
            int fee = dFee;
            if (entry.getValue() > dTime) {
                fee += (int) (Math.ceil((double) (entry.getValue() - dTime) / unitTime) * unitFee);
            }
            int carNum = Integer.parseInt(entry.getKey());
            result.add(List.of(carNum, fee));
        }
        result.sort((o1, o2) -> o1.get(0) - o2.get(0));

        return result.stream().map(v -> v.get(1)).mapToInt(v -> v).toArray();
    }

    public int getTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}