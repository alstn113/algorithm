class Solution {
    public int solution(int n, int a, int b) {
        if (a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        int i = 1;

        while (true) {
            if (a % 2 == 1 && a + 1 == b) {
                break;
            }

            a = next(a);
            b = next(b);

            i += 1;
        }

        return i;
    }

    public int next(int n) {
        return (n - 1) / 2 + 1;
    }
}
