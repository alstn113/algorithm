class Solution {
    public int solution(String dartResult) {
        int[] result = new int[3];
        
        int i = 0;
        for (int k=0; k<3; k++) {
            // 첫 번째
            char c = dartResult.charAt(i);
            char nc = dartResult.charAt(i+1);
            if (c == '1' && nc == '0') {
                result[k] = 10;                      
                i += 1;
            } else {
                result[k] = Integer.parseInt(String.valueOf(c));                
            }
            i += 1;
            
            // 두 번째
            char oc = dartResult.charAt(i);
            if (oc == 'D') {
                result[k] = result[k] * result[k];
            } else if (oc == 'T') {
                result[k] = result[k] * result[k] * result[k];
            }
            i += 1;
            
            // 세 번째
            if (i < dartResult.length()) {
                if (dartResult.charAt(i) == '*') {
                    result[k] *= 2;
                    if (k > 0) {
                        result[k-1] *= 2;
                    }
                    i += 1;
                } else if (dartResult.charAt(i) == '#') {
                    result[k] *= -1;
                    i += 1;
                }
            }
        }
        
        
        return result[0] + result[1] + result[2];
    }
}