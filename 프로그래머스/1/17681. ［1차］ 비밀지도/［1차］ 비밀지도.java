class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String v = Integer.toBinaryString(arr1[i] | arr2[i]);
            StringBuilder binary = new StringBuilder(v);

            while (binary.length() < n) {
                binary.insert(0, "0");
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (binary.charAt(j) == '0') {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }

            result[i] = sb.toString();
        }

        return result;
    }
}