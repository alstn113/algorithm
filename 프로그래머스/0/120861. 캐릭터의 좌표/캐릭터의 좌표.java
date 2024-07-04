class Solution {
     public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        int maxX = (board[0] - 1) / 2;
        int maxY = (board[1] - 1) / 2;

        for (String key : keyinput) {
            switch (key) {
                case "up":
                    if (y + 1 <= maxY) {
                        y++;
                    }
                    break;
                case "down":
                    if (y - 1 >= -maxY) {
                        y--;
                    }
                    break;
                case "left":
                    if (x - 1 >= -maxX) {
                        x--;
                    }
                    break;
                case "right":
                    if (x + 1 <= maxX) {
                        x++;
                    }
                    break;
                default:
                    break;
            }
        }

        return new int[]{x, y};
    }
}