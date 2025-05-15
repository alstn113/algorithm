package grammar.step;

import java.util.HashMap;
import java.util.Map;

public class Step8키값 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("apple", "사과");
        map.put("banana", "바나나");

        // 키와 값의 쌍으로 저장
        map.remove("apple"); // 키로 삭제

        // 확인
        map.get("banana"); // 값으로 확인
        map.getOrDefault("kiwi", "키위"); // 기본값 설정
        map.containsKey("banana"); // 키 존재 여부 확인
        map.containsValue("바나나"); // 값 존재 여부 확인

        // 반복문
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // stream
        map.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith("b"))
                .forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
    }
}
