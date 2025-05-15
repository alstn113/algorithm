package grammar.step;

public class Step1문자열 {

    public static void main(String[] args) {
        // 문자열 길이
        String apple = "apple";
        System.out.println("문자열 길이: " + apple.length()); // 5

        // 빈 문자열 체크
        System.out.println("a".isEmpty()); // false
        System.out.println("".isEmpty()); // true
        System.out.println(" ".isEmpty()); // false
        System.out.println("".isBlank()); // true

        // 문자 찾기
        // indexOf는 특정 문자의 인덱스를 반환, 없으면 -1
        System.out.println(apple.indexOf("p")); // 1
        System.out.println(apple.indexOf("z")); // -1
        System.out.println(apple.indexOf("p", 2)); // 2번째 인덱스부터 찾기
        System.out.println(apple.lastIndexOf("p")); // 2

        // 문자열 자르기
        // substring은 특정 인덱스부터 끝까지 자르기
        System.out.println(apple.substring(1)); // pple
        System.out.println(apple.substring(1, 3)); // pp (1번 인덱스부터 3번 인덱스 전까지)

        // 문자 변경
        // replace는 특정 문자를 다른 문자로 변경
        // 기존 문자열은 변경되지 않음 -> 반환되는 새로운 문자열을 사용해야 함
        System.out.println(apple.replace("p", "P")); // aPPle
        System.out.println(apple.replaceFirst("e", "E")); // applE
        System.out.println(apple.replaceAll("p", "P")); // aPPle

        // 문자 동일 여부 판단
        // 문자열은 ==로 비교하면 안됨, equals()로 비교해야 함
        String str1 = "apple";
        String str2 = "apple";
        String str3 = new String("apple");
        System.out.println(str1 == str2); // true (문자열 리터럴은 동일한 객체를 참조)
        System.out.println(str1 == str3); // false (new로 생성된 객체는 다른 참조)
        System.out.println(str1.equals(str3)); // true (문자열 내용 비교)
        System.out.println(str1.equalsIgnoreCase("APPLE")); // true (대소문자 무시)

        // 문자 비교
        // compareTo는 두 문자열을 비교하여 사전적 순서를 반환
        // 사전 순으로 앞이면 -1, 뒤면 1, 같으면 0을 반환
        System.out.println("apple".compareTo("banana")); // -1 (apple이 banana보다 앞)

        // 포함 여부 판단
        // contains는 특정 문자열이 포함되어 있는지 확인
        System.out.println(apple.contains("pp")); // true

        // 문자열 분리
        // split은 특정 구분자로 문자열을 나누어 배열로 반환
        String str = "apple,banana,kiwi";
        String[] fruits = str.split(","); // ["apple", "banana", "kiwi"]
        // str.split("") 은 문자열을 문자 단위로 나누는 것
        // str.trim()은 문자열 양쪽의 공백을 제거

        // 대소문자 변경
        // toUpperCase는 대문자로, toLowerCase는 소문자로 변경
        System.out.println(apple.toUpperCase()); // APPLE
        System.out.println(apple.toLowerCase()); // apple

        // 문자 <-> 숫자 변환
        // Integer.parseInt("100")는 문자열을 정수로 변환
        // Double.parseDouble("3.14")는 문자열을 실수로 변환
        // Integer.toString(100)은 정수를 문자열로 변환

    }
}
