import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 친구들의 이름을 인덱스로 변환
        Map<String, Integer> ids = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            ids.put(friends[i], i);
        }

        // 선물 주고 받은 수 저장
        int[][] arr = new int[friends.length][friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                arr[i][j] = 0;
            }
        }

        // 선물 주고 받기 처리
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int from = ids.get(split[0]);
            int to = ids.get(split[1]);
            arr[from][to]++;
        }

        // 선물 지수 계산
        int[] factors = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            int count = 0;
            for (int j = 0; j < friends.length; j++) {
                count += arr[i][j];
            }

            for (int j = 0; j < friends.length; j++) {
                count -= arr[j][i];
            }

            factors[i] = count;
        }

        // 선물받은 수 리스트
        int[] received = new int[friends.length];

        // 선물 주고 받은 수 및 지수로 처리
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {

                int a = arr[i][j]; // i가 j에게 준 선물 수
                int b = arr[j][i]; // j가 i에게 준 선물 수

                // 선물 지수로 처리
                if (a == b) {
                    if (factors[i] > factors[j]) {
                        received[i]++;
                    } else if (factors[i] < factors[j]) {
                        received[j]++;
                    }
                    // 지수 같으면 무시

                    continue;
                }

                // 선물 받은 수로 처리
                if (a > b) {
                    received[i]++;
                } else {
                    received[j]++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < friends.length; i++) {
            max = Math.max(max, received[i]);
        }

        return max;
    }
}