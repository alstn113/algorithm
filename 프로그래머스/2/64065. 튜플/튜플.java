import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.transform.sax.SAXResult;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] split = s.split("},\\{", -1);
        Map<Integer, Integer> dic = new HashMap<>();

        for (String v : split) {
            String[] arrSplit = v.split(",", -1);
            for (String as : arrSplit) {
                int a = Integer.parseInt(as);
                dic.put(a, dic.getOrDefault(a, 0) + 1);
            }
        }

        return dic.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(Entry::getKey)
                .mapToInt(k -> k)
                .toArray();
    }
}