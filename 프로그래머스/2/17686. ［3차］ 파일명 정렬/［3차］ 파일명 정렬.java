import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> result = new ArrayList<>();
        
        for (String file : files) {
            int idx = 0;
            
            while(true) {
                char c = file.charAt(idx);
                if (!Character.isDigit(c)) {
                    idx += 1;
                } else {
                    break;
                }
            }
            
            int tmpIdx = idx;
            String head = file.substring(0, idx).toUpperCase();
            
            int limit = 5;
            while (limit > 0 && idx < file.length()) {
                char c = file.charAt(idx);
                if (Character.isDigit(c)) {
                    idx += 1;
                    limit -= 1;
                } else {
                    break;
                }
            }
            int number = Integer.parseInt(file.substring(tmpIdx, idx));
            
            File newFile = new File(file, head, number);
            result.add(newFile);
        }        
        
        result.sort((o1, o2) -> {
            if (o1.head.equals(o2.head)) {
                return o1.number - o2.number;
            }
            return o1.head.compareTo(o2.head);
        });
        
        return result.stream().map(v -> v.real).toArray(String[]::new);
    }
    
    class File {
        String real;
        String head;
        int number;
        
        public File(String real, String head, int number) {
            this.real = real;
            this.head = head;
            this.number = number;
        }
    }
}