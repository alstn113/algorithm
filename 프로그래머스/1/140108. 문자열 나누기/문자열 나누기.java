class Solution {
    public int solution(String s) {
        boolean flag = false;
        char target = 'a';
        int a = 0;
        int b = 0;
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            if(!flag) {
                target = s.charAt(i);
                a += 1;
                flag = true;
            } else {
                if (s.charAt(i) == target) {
                    a += 1;
                } else {
                    b += 1;
                }

                if (a == b) {
                    flag = false;
                    System.out.println(a + " " + b);
                    a = 0;
                    b = 0;
                    result += 1;
                }
            }
        }
        
        if (a != b) {
            result += 1;
        }

        return result;
    }
}