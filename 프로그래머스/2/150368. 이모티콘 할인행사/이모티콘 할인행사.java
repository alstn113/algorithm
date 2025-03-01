import java.util.*;

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        List<List<Integer>> discounts = new ArrayList<>();
        int[] rates = {10, 20, 30, 40};

        dfs(discounts, rates, new ArrayList<>(), 0, emoticons.length);

        List<Tuple> answer = new ArrayList<>();

        for (List<Integer> discount : discounts) {
            int register = 0;
            int money = 0;

            for (int[] user : users) {
                int rate = user[0];
                int plusLimit = user[1];

                int cost = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (rate <= discount.get(i)) {
                        cost += emoticons[i] * (100 - discount.get(i)) / 100;
                    }
                }

                if (cost >= plusLimit) {
                    register += 1;
                } else {
                    money += cost;
                }
            }

            answer.add(new Tuple(register, money));
        }

        answer.sort((o1, o2) -> {
            if (o1.registerCount == o2.registerCount) {
                return o2.profit - o1.profit;
            }
            return o2.registerCount - o1.registerCount;
        });

        return new int[]{answer.get(0).registerCount, answer.get(0).profit};
    }

    public void dfs(List<List<Integer>> discounts, int[] rates, List<Integer> cur, int depth, int n) {
        if (depth == n) {
            discounts.add(new ArrayList<>(cur));
            return;
        }

        for (int rate : rates) {
            cur.add(rate);
            dfs(discounts, rates, cur, depth + 1, n);
            cur.remove(cur.size() - 1);
        }
    }

    class Tuple {
        public int registerCount;
        public int profit;

        public Tuple(int registerCount, int profit) {
            this.registerCount = registerCount;
            this.profit = profit;
        }
    }
}
