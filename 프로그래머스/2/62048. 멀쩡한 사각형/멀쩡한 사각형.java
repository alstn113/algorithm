class Solution {
    public long solution(int w, int h) {
        long remove = w + h - gcd(w, h);
        return  (long) w * h - remove;
    }

    public long gcd(long w, long h) {
        if (h == 0) {
            return w;
        }
        if (w > h) {
            return gcd(h, w % h);
        }
        return gcd(w, h % w);
    }
}