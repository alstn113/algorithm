import java.util.*;

class Solution {
    public String solution(
            String video_len,
            String pos,
            String op_start,
            String op_end,
            String[] commands
    ) {
        int videoLen = getDate(video_len);
        int position = getDate(pos);
        int opStart = getDate(op_start);
        int opEnd = getDate(op_end);

        if (position >= opStart && position <= opEnd) {
            position = opEnd;
        }
        

        for (String command : commands) {
            if (command.equals("next")) {
                position += 10;
                position = Math.min(videoLen, position);
            } else {
                position -= 10;
                position = Math.max(0, position);
            }


            if (position >= opStart && position <= opEnd) {
                position = opEnd;
            }
            
        }

        return processDate(position);
    }

    public int getDate(String date) {
        String[] split = date.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        return h * 60 + m;
    }

    public String processDate(int date) {
        int h = (date / 60);
        int m = (date % 60);

        StringBuilder sb = new StringBuilder();
        if (h < 10) sb.append("0").append(h);
        else sb.append(h);
        
        sb.append(":");

        if (m < 10) sb.append("0").append(m);
        else sb.append(m);

        return sb.toString();
    }
}