class Solution {
    public int solution(String[] board) {
        int o = 0;
        int x = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    o += 1;
                } else if (board[i].charAt(j) == 'X') {
                    x += 1;
                }
            }
        }
        boolean oWin = check(board, 'O');
        boolean xWin = check(board, 'X');

        if (o == x && !oWin) return 1;
        if (o == x + 1 && !xWin) return 1;

        return 0;
    }

    public boolean check(String[] board, char c) {
        String target = String.valueOf(c).repeat(3);
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(target)) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j].charAt(i) != c) {
                    break;
                }
                if (j == 2) {
                    return true;
                }
            }
        }
    
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
            return true;
        }
        
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) {
            return true;
        }
        
        return false;
    }
}