class Solution {
    public String[] solution(String[] names) {
        String[] result = new String[(names.length -1) / 5 + 1];
        for (int i = 0; i < result.length; i++ ){
            result[i] = names[i * 5];
        }
        return result;
    }
}