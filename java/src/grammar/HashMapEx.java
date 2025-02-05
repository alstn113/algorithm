package grammar;

import java.util.*;

public class HashMapEx {

    public static void main(String[] args) {
        // HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // 요소 추가
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        // 요소 제거
        map.remove("b");

        // 요소 수정
        map.replace("c", 33);

        // 요소 확인
        System.out.println(map.get("a")); // 1

        // 요소 개수
        System.out.println(map.size()); // 2

        // 요소 포함 여부
        System.out.println(map.containsKey("a")); // true
        System.out.println(map.containsValue(33)); // true

        // 요소 비우기
        // map.clear();

        // 요소 순회
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
