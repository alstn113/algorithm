import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        // 할인율에 따라 모두 구매 10 20 30 40
        // 이모티콘으로 모두 탐색
        List<List<Integer>> arr = new ArrayList<>();
        int[] sales = new int[]{10, 20, 30, 40};
        int n = emoticons.length;
        dfs(arr, sales, n, new ArrayList<>());

        List<List<Integer>> result = new ArrayList<>();

        // 이모티콘의 할인 경우의 수
        for (int i = 0; i < arr.size(); i++) {
            int service = 0;
            int money = 0;

            // 사용자 순회
            for (int j = 0; j < users.length; j++) {
                int saleLimit = users[j][0];
                int moneyLimit = users[j][1];

                int sum = 0;
                // 이모티콘 순회
                for (int k = 0; k < n; k++) {
                    int targetSale = arr.get(i).get(k);
                    if (saleLimit <= targetSale) {
                        sum += emoticons[k] - (emoticons[k] * targetSale / 100);
                    }
                }
                if (sum >= moneyLimit) {
                    service += 1;
                } else {
                    money += sum;
                }
            }
            
            result.add(List.of(service, money));
        }

        result.sort((o1, o2) -> {
            if (o1.get(0).equals(o2.get(0))) {
                return o2.get(1) - o1.get(1);
            }
            return o2.get(0) - o1.get(0);
        });

        List<Integer> answer = result.get(0);
        return new int[]{answer.get(0), answer.get(1)};
    }

    public void dfs(List<List<Integer>> arr, int[] sales, int n, List<Integer> cur) {
        if (cur.size() == n) {
            arr.add(new ArrayList<>(cur));
            return;
        }

        for (int s : sales) {
            cur.add(s);
            dfs(arr, sales, n, new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
        }
    }
}