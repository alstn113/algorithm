import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerIndexMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }

        for (String calling : callings) {
            int currentIndex = playerIndexMap.get(calling);
            if (currentIndex > 0) { 
                String tmp = players[currentIndex - 1];

                players[currentIndex] = tmp;
                players[currentIndex - 1] = calling;
                
                playerIndexMap.put(tmp, currentIndex);
                playerIndexMap.put(calling, currentIndex - 1);
            }
        }

        return players;
    }
}
