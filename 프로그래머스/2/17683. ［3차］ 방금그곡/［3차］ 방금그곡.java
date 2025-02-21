import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<String> answer = new ArrayList<>();
        List<Integer> answerTime = new ArrayList<>();

        m = replaceAcbo(m);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] split = musicinfos[i].split(",");

            String from = split[0];
            String to = split[1];
            int time = getTime(from, to);

            String title = split[2];
            String melody = extendMelody(replaceAcbo(split[3]), time);

            if (melody.contains(m)) {
                answer.add(title);
                answerTime.add(time);
            }
        }

        if (answer.isEmpty()) {
            return "(None)";
        }

        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < answerTime.size(); i++) {
            if (answerTime.get(i) > max) {
                max = answerTime.get(i);
                maxIndex = i;
            }
        }

        return answer.get(maxIndex);
    }

    public String replaceAcbo(String from) {
        from = from.replace("C#", "c");
        from = from.replace("B#", "b");
        from = from.replace("D#", "d");
        from = from.replace("F#", "f");
        from = from.replace("G#", "g");
        from = from.replace("A#", "a");

        return from;
    }

    public int getTime(String from, String to) {
        String[] fromArr = from.split(":");
        String[] toArr = to.split(":");

        int fromHour = Integer.parseInt(fromArr[0]);
        int fromMinute = Integer.parseInt(fromArr[1]);

        int toHour = Integer.parseInt(toArr[0]);
        int toMinute = Integer.parseInt(toArr[1]);

        return (toHour - fromHour) * 60 + (toMinute - fromMinute);
    }

    public String extendMelody(String melody, int time) {
        int n = time / melody.length();
        int m = time % melody.length();

        return melody.repeat(n) + melody.substring(0, m);
    }
}