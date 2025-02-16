import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int left = 0;
        int right = people.length - 1;
        int answer = 0;

        Arrays.sort(people);

        while (left <= right) {
            if (people[right] + people[left] <= limit) {
                left += 1;
            }

            right -= 1;
            answer += 1;
        }

        return answer;
    }
}