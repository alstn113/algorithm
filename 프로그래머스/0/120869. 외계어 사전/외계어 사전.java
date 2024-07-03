class Solution {
    public int solution(String[] spell, String[] dic) {
        for (int i = 0; i < dic.length; i++) {
            int answer = 0;
            for (int j = 0; j < spell.length; j++) {
                if (dic[i].contains(spell[j])) {
                    answer++;
                }
            }
            if (answer == spell.length) {
                return 1;
            }
        }
        return 2;
    }
}