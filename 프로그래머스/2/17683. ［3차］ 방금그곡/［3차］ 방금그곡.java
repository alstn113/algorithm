import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        // 음악 길이 < 재생 시간 -> 반복
        // 음악 길이 > 재생 시간 -> 처음부터 재생 시간 만큼

        // 일치 음악 여러 개 -> 재생 시간 제일 긴 것 -> 먼저 입력

        List<Music> result = new ArrayList<>();

        m = convert(m);

        for (String ms : musicinfos) {
            String[] split = ms.split(",");
            int time = getTime(split[1]) - getTime(split[0]);
            String title = split[2];
            String melody = convert(split[3]);

            String play = melody;
            if (melody.length() < time) {
                play = melody.repeat(time / melody.length() + 1);
                play = play.substring(0, time);
            } else if (melody.length() > time) {
                play = melody.substring(0, time);
            }

            if (play.contains(m)) {
                result.add(new Music(play.length(), title));
            }
        }

        if(result.isEmpty()) {
            return "(None)";
        }

        result.sort((o1, o2) -> {
            return o2.pt - o1.pt;
        });


        return result.get(0).title;
    }

    class Music {
        int pt;
        String title;

        public Music(int pt, String title) {
            this.pt = pt;
            this.title = title;
        }
    }

    public int getTime(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]) * 60;
        int m = Integer.parseInt(split[1]);

        return h + m;
    }

    public String convert(String str) {
        str = str.replaceAll("C#", "c");
        str = str.replaceAll("D#", "d");
        str = str.replaceAll("F#", "f");
        str = str.replaceAll("G#", "g");
        str = str.replaceAll("A#", "a");
        str = str.replaceAll("B#", "b");
        str = str.replaceAll("E#", "e");

        return str;
    }
}
