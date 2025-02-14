class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = -1;
        int luy = wallpaper[0].length();
        int rdx = 0;
        int rdy = 0;

        for (int i=0; i<wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                if (lux == -1) {
                    lux = i;
                }
                rdx = i;
            }

            for (int j=0; j<wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    luy = Math.min(luy, j);
                    rdy = Math.max(rdy, j);
                }
            }
        }

        return new int[]{lux, luy, rdx+1, rdy+1};
    }
}