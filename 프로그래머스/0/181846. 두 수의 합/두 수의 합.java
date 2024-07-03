import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger n1 = new BigInteger(a);
        BigInteger n2 = new BigInteger(b);
        return String.valueOf(n1.add(n2));
    }
}