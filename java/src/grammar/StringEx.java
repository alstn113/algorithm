package grammar;

public class StringEx {

    public static void main(String[] args) {
        String str = "apple";

        // 길이
        System.out.println(str.length()); // 5

        // 문자열 결합
        System.out.println(str.concat("banana")); // applebanana
        System.out.println(str + "banana"); // applebanana

        // 문자열 비교
        System.out.println(str.equals("apple")); // true
        System.out.println(str.equalsIgnoreCase("APPLE")); // true

        // 문자열 찾기
        System.out.println(str.indexOf("p")); // 1
        System.out.println(str.lastIndexOf("p")); // 2
        System.out.println(str.indexOf("p", 2)); // 2번째 인덱스부터 찾기
        System.out.println(str.indexOf("z")); // -1 (없으면 -1)

        // 문자열 자르기
        System.out.println(str.substring(1)); // pple (1번 인덱스부터 끝까지)
        System.out.println(str.substring(1, 3)); // pp (1번 인덱스부터 3번 인덱스 전까지)

        // 문자열 바꾸기
        System.out.println(str.replace("p", "P")); // aPPle
        System.out.println(str.replaceFirst("e", "E")); // applE

        // 문자열 나누기
        System.out.println("apple,banana,kiwi".split(",")); // [apple, banana, kiwi]

        // 문자열 공백 제거
        System.out.println("  apple  ".trim()); // apple

        // 문자열 대소문자 변경
        System.out.println(str.toUpperCase()); // APPLE
        System.out.println(str.toLowerCase()); // apple

        // 문자열을 숫자로 변환
        System.out.println(Integer.parseInt("123")); // 123
        System.out.println(Double.parseDouble("3.14")); // 3.14

        // 숫자를 문자열로 변환
        System.out.println(123); // "123"
        System.out.println(3.14); // "3.14"

        // 문자열을 문자 배열로 변환
        char[] charArray = str.toCharArray();
        System.out.println(charArray); // [a, p, p, l, e]

        // isEmpty vs isBlank
        System.out.println("".isEmpty()); // true
        System.out.println(" ".isEmpty()); // false
        System.out.println("".isBlank()); // true
        System.out.println(" ".isBlank()); // true

        // 특정 문자로 시작 또는 끝나는지 확인
        System.out.println(str.startsWith("a")); // true
        System.out.println(str.endsWith("e")); // true

        // 문자열 포함 여부
        System.out.println(str.contains("pp")); // true
    }
}
