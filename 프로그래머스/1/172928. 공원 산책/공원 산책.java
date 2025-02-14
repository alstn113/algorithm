class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] position = findStartLocation(park);

        for (String route : routes) {
            String[] r = route.split(" ");
            String direction = r[0];
            int distance = Integer.parseInt(r[1]);

            int dx = 0, dy = 0;
            switch (direction) {
                case "E": dy = 1; break;
                case "W": dy = -1; break;
                case "S": dx = 1; break;
                case "N": dx = -1; break;
            }

            if (canMove(park, position, dx, dy, distance)) {
                position[0] += dx * distance;
                position[1] += dy * distance;
            }
        }

        return position;
    }

    private boolean canMove(String[] park, int[] position, int dx, int dy, int distance) {
        for (int i = 1; i <= distance; i++) {
            int nx = position[0] + dx * i;
            int ny = position[1] + dy * i;

            if (nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length()) {
                return false;
            }

            if (park[nx].charAt(ny) == 'X') {
                return false;
            }
        }
        return true;
    }

    public int[] findStartLocation(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
