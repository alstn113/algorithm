import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String[] aSplit = splitFileName(a);
            String[] bSplit = splitFileName(b);

            String aHead = aSplit[0].toLowerCase();
            String bHead = bSplit[0].toLowerCase();

            if (aHead.equals(bHead)) {
                int aNumber = Integer.parseInt(aSplit[1]);
                int bNumber = Integer.parseInt(bSplit[1]);

                return aNumber - bNumber;
            }

            return aHead.compareTo(bHead);
        });

        return files;
    }

    public String[] splitFileName(String file) {
        int numberStart = -1;
        int numberEnd = -1;
        for (int i = 0; i < file.length(); i++) {
            if (numberStart == -1 && Character.isDigit(file.charAt(i))) {
                numberStart = i;
            }

            if (numberStart != -1 && !Character.isDigit(file.charAt(i))) {
                numberEnd = i - 1;
                break;
            }
        }

        if (numberEnd == -1) {
            numberEnd = file.length() - 1;
        }

        return new String[]{
                file.substring(0, numberStart),
                file.substring(numberStart, numberEnd + 1),
                file.substring(numberEnd + 1),
        };
    }
}