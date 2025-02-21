class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int a = n / 3;
            int b = n % 3;

            if (b == 1) {
                sb.insert(0, "1");
            } else if (b == 2) {
                sb.insert(0, "2");
            } else {
                sb.insert(0, "4");
                a -= 1;
            }

            n = a;
        }

        return sb.toString();
    }
}