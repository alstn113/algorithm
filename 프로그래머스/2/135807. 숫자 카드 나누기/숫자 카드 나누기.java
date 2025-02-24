class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int a = getGcd(arrayA);
        int b = getGcd(arrayB);

        boolean isA = false;
        for (int v : arrayA) {
            if (v % b == 0) {
                isA = true;
                break;
            }
        }


        boolean isB = false;
        for (int v : arrayB) {
            if (v % a == 0) {
                isB = true;
                break;
            }
        }
    
        if (isA && isB) {
            return 0;
        }
        return Math.max(a, b);
    }

    public int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }

        if (n > m) {
            return gcd(m, n % m);
        }

        return gcd(n, m % n);
    }

    public int getGcd(int[] arr) {
        int n = arr.length;
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            temp = gcd(temp, arr[i]);
        }
        return temp;
    }
}

