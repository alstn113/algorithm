import java.util.Map;

class Solution {

    static int[][] fatigueLevel = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}
    };
    static int minFatigue = (int) 1e9;
    static Map<String, Integer> dic = Map.of(
            "diamond", 0,
            "iron", 1,
            "stone", 2
    );

    public int solution(int[] picks, String[] minerals) {
        dfs(picks[0], picks[1], picks[2], minerals, 0, 0);

        return minFatigue;
    }

    public void dfs(int diamond, int iron, int stone, String[] minerals, int fatigue, int startIndex) {
        if ((diamond == 0 && iron == 0 && stone == 0) || minerals.length < startIndex) {
            minFatigue = Math.min(minFatigue, fatigue);
            return;
        }

        int maxMine = Math.min(5, minerals.length - startIndex);

        if (diamond > 0) {
            int nextFatigue = fatigue + calcFatigue(0, minerals, startIndex, maxMine);
            dfs(diamond - 1, iron, stone, minerals, nextFatigue, startIndex + maxMine);
        }

        if (iron > 0) {
            int nextFatigue = fatigue + calcFatigue(1, minerals, startIndex, maxMine);
            dfs(diamond, iron - 1, stone, minerals, nextFatigue, startIndex + maxMine);
        }

        if (stone > 0) {
            int nextFatigue = fatigue + calcFatigue(2, minerals, startIndex, maxMine);
            dfs(diamond, iron, stone - 1, minerals, nextFatigue, startIndex + maxMine);
        }
    }

    public int calcFatigue(int pick, String[] minerals, int startIndex, int count) {
        int fatigue = 0;
        for (int i = 0; i < count; i++) {
            fatigue += fatigueLevel[pick][dic.get(minerals[startIndex + i])];
        }
        return fatigue;
    }
}