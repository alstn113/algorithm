import java.util.HashMap;
import java.util.Map.Entry;

class HashMapEx {
    public static void main(String[] args) {
        // HashMap: <key, value> 쌍, value 중복 허용 o, 순서 x
        // LinkedHashMap: <key, value> 쌍, value 중복 허용 o, 순서 o
        // TreeMap: <key, value> 쌍, key 순서가 오름차순(알파벳순)으로 정렬

        // 해시맵 생성
        HashMap<String, Integer> map = new HashMap<>();

        // 요소 추가
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        // 요소 제거
        map.remove("a");

        // 요소 수정
        map.replace("b", 4);

        // 요소 확인
        System.out.println(map.get("b")); // 4

        // 요소 개수
        System.out.println(map.size()); // 2

        // 요소 포함 여부
        System.out.println(map.containsKey("b")); // true
        System.out.println(map.containsValue(4)); // true

        // 요소 비우기
        map.clear();

        // 요소 개수
        System.out.println(map.size()); // 0

        // 순회
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
