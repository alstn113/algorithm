class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            StringBuilder result = new StringBuilder();
            for (char c : skill_tree.toCharArray()) {
                if (skill.contains(String.valueOf(c))) {
                    result.append(c);
                }
            }
            
            if (skill.startsWith(result.toString())) {
                answer += 1;
            }
        }
        
        return answer;
    }
}