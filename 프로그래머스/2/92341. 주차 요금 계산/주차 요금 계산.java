import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> carTime = new HashMap<>();
        Map<String, Integer> carFee = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            int time = getTime(split[0]);
            String num = split[1];
            boolean in = split[2].equals("IN");

            if (in) {
                carTime.put(num, time);
            } else {
                int totalTime = time - carTime.get(num);
                carFee.put(num, carFee.getOrDefault(num, 0) + totalTime);
                carTime.remove(num);
            }
        }

        int lastOutTime = getTime("23:59");
        for (Map.Entry<String, Integer> entry : carTime.entrySet()) {
            String num = entry.getKey();
            int inTime = entry.getValue();

            int time = lastOutTime - inTime;

            carFee.put(num, carFee.getOrDefault(num, 0) + time);
        }

        // 출력
        for (Map.Entry<String, Integer> entry : carFee.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return carFee.entrySet().stream()
                .sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
                .map(entry -> getFee(fees, entry.getValue()))
                .mapToInt(v -> v)
                .toArray();
    }

    public int getTime(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        return h * 60 + m;
    }

    public int getFee(int[] fees, int time) {
        if (time <= fees[0]) {
            return fees[1];
        }

        int fee = fees[1];
        time -= fees[0];
        fee += (int) (Math.ceil((double) time / fees[2]) * fees[3]);

        return fee;
    }
}