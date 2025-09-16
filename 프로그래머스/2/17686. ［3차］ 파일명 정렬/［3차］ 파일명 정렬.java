import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        List<File> result = new ArrayList<>();
        for (String file : files) {
            int n = file.length();
            int i = 0;
            StringBuilder sb = new StringBuilder();

            while (true) {
                char target = file.charAt(i);
                if (!Character.isDigit(target)) {
                    sb.append(target);
                    i += 1;
                } else {
                    break;
                }
            }

            String head = sb.toString().toUpperCase();

            int k = 5;
            StringBuilder sb1 = new StringBuilder();
            while (k > 0 && i < n) {
                char target = file.charAt(i);
                if (Character.isDigit(target)) {
                    sb1.append(target);
                    i += 1;
                    k -= 1;
                } else {
                    break;
                }
            }
            int number = Integer.parseInt(sb1.toString());

            result.add(new File(file, head, number));
        }

        result.sort((o1, o2) -> {
            if (o1.head.equals(o2.head)) {
                return o1.number - o2.number;
            }
            return o1.head.compareTo(o2.head);
        });

        return result.stream().map(file -> file.name).toArray(String[]::new);
    }

    class File {
        String name;
        String head; // 대소문자 x
        int number; // 숫자로

        public File(String name, String head, int number) {
            this.name = name;
            this.head = head;
            this.number = number;
        }
    }
}