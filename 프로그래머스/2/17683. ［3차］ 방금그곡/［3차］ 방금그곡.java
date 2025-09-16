import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<Music> result = new ArrayList<>();

        m = convert(m);

        for (String info : musicinfos) {
            String[] split = info.split(",");
            int time = getTime(split[1]) - getTime(split[0]);
            String name = split[2];
            String melody = convert(split[3]);
            if (melody.length() < time) {
                melody = melody.repeat(time / melody.length() + 1);
                melody = melody.substring(0, time);
            } else if (melody.length() > time) {
                melody = melody.substring(0, time);
            }

            if (melody.contains(m)) {
                result.add(new Music(time, name));
            }
        }

        result.sort((o1, o2) -> {
            return o2.time - o1.time;
        });

        if (result.isEmpty()) {
            return "(None)";
        }
        return result.get(0).name;
    }

    class Music {
        int time;
        String name;

        public Music(int time, String name) {
            this.time = time;
            this.name = name;
        }
    }

    public int getTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
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

