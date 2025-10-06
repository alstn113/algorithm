class Solution {
    public int[] solution(long[] numbers) {
        int[] result = new int[numbers.length];
        
        for (int i=0; i<numbers.length; i++) {
            String v = Long.toString(numbers[i], 2);
            int len = v.length();
            int[] arr = new int[] {1, 3, 7, 15, 31, 63};
            for (int a : arr) {
                if (len <= a) {
                    v = "0".repeat(a - len) + v;
                    break;
                }         
            }
            
            // 가능하면 true; 불가능하면 false;
            if(dfs(v, true)) {
                result[i] = 1;
            }
        }   
         
        return result;
    }
    
    public boolean dfs(String v, boolean prevOne) {
        int len = v.length();
        if (len == 1) {
            if(!prevOne && v.equals("1")) {
                return false;
            }
            return true;
        }
        
        String left = v.substring(0, len / 2);
        char mid = v.charAt(len / 2);
        String right = v.substring(len / 2 + 1);

        boolean prev = mid == '1';
        if (!prevOne && prev) {
            return false;
        }
        
        return dfs(left, prev) && dfs(right, prev);
    }
}