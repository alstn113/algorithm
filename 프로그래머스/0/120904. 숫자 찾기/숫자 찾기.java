class Solution {
    public int solution(int num, int k) {
        String numString = Integer.toString(num);
        String[] numArray = numString.split("");
        for (int i =0; i< numArray.length; i++) {
            if (numArray[i].equals(Integer.toString(k))) {
                return i+1;
            }
        }
        return -1;
    }
}