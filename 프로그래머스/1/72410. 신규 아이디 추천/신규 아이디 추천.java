class Solution {
    public String solution(String new_id) {
        // 1
        new_id = new_id.toLowerCase();

        // 2
        StringBuilder sb = new StringBuilder();
        for (Character c : new_id.toCharArray()) {
            if (Character.isDigit(c) || Character.isAlphabetic(c) || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        new_id = sb.toString();
        System.out.println(new_id);

        // 3
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        System.out.println(new_id);

        // 4
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        System.out.println(new_id);

        // 5
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        System.out.println(new_id);

        // 6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        System.out.println(new_id);

        // 7
        if (new_id.length() <= 2) {
            while(new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() -1);
            }
        }
        System.out.println(new_id);

        return new_id;
    }
}