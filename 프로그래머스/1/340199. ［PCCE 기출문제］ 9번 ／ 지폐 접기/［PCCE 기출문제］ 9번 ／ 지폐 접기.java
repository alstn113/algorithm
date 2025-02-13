import java.util.*;

class Solution {    
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true) {
            if((wallet[0] >= bill[0] && wallet[1] >= bill[1]) || (wallet[0] >= bill[1] && wallet[1] >= bill[0])) {
                return answer;
            }

            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer += 1;
            System.out.println(bill[0] + " " + bill[1]);
        }
    }
}