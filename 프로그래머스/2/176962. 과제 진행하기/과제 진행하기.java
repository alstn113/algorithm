import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (o1, o2) -> {
            return getTime(o1[1]) - getTime(o2[1]);
        });

        Stack<Tuple> st = new Stack<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < plans.length - 1; i++) {
            String[] plan = plans[i];
            String name = plan[0];
            System.out.println("name: " + name);
            int time = getTime(plan[1]);
            int remain = Integer.parseInt(plan[2]);

            String[] nextPlan = plans[i + 1];
            int nextTime = getTime(nextPlan[1]);

            if (time + remain > nextTime) {
                st.add(new Tuple(time + remain - nextTime, name));
                continue;
            }

            int v = nextTime - time - remain;
            answer.add(name);

            while (v > 0 && !st.isEmpty()) {
                Tuple tuple = st.pop();
                if (tuple.remain > v) {
                    st.push(new Tuple(tuple.remain - v, tuple.name));
                    break;
                } else {
                    v -= tuple.remain;
                    answer.add(tuple.name);
                }
            }
        }

        answer.add(plans[plans.length-1][0]);

        while (!st.isEmpty()) {
            Tuple tuple = st.pop();
            answer.add(tuple.name);
        }


        return answer.toArray(String[]::new);
    }

    public int getTime(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        return h * 60 + m;
    }
}

class Tuple {

    public int remain;
    public String name;

    public Tuple(int remain, String name) {
        this.remain = remain;
        this.name = name;
    }
}