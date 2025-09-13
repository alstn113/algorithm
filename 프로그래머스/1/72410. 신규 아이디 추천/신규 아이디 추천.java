class Solution {
    public String solution(String new_id) {
        // 1
        new_id = new_id.toLowerCase();

        // 2
        StringBuilder sb = new StringBuilder();
        for (char c : new_id.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        new_id = sb.toString();

        // 3
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        // 4
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }

        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 5
        if (new_id.isBlank()) {
            new_id = "a";
        }

        // 6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }

        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 7
        while (new_id.length() <= 2) {
            new_id = new_id + new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}