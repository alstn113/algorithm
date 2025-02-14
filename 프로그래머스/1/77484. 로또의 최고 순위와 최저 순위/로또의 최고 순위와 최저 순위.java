class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0;
        int correct = 0;
        
        for (int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) zero += 1;
            
            for (int j=0; j<lottos.length; j++) {
                if (lottos[i] == win_nums[j]) correct += 1;
            }
        }
        System.out.println(correct + " " + zero);
        
        return new int[] { 
            Math.min(Math.abs(7-(correct+zero)), 6), 
            Math.min(Math.abs(7-correct), 6) 
        };
    }
}