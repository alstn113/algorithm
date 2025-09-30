class Solution {
    public int[] solution(long[] numbers) {
        int[] ff = new int[]{1, 3, 7, 15, 31, 63};
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            String bin = Long.toString(number, 2);
            int binLen = bin.length();
            for (int k = 0; k < ff.length; k++) {
                if (binLen == ff[k]) {
                    break;
                }
                if (binLen < ff[k]) {
                    bin = "0".repeat(ff[k] - binLen) + bin;
                    break;
                }
            }

            if (dfs(bin, true)) {
                result[i] = 1;
            }
        }
        return result;
    }

    public boolean dfs(String target, boolean prevOne) {
        if (target.length() == 1) {
            if(!prevOne && target.equals("1")) {
                return false;
            }
            return true;
        }

        int len = target.length() / 2;
        String left = target.substring(0, len);
        char mid = target.charAt(len);
        String right = target.substring(len + 1);

        boolean isMidOne = mid == '1';
        if (!prevOne && isMidOne) {
            return false;
        }

        return dfs(left, isMidOne) && dfs(right, isMidOne);
    }
} 