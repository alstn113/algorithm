class StringEx {
    public static void main(String[] args) {
        String str = "apple";

        // 길이
        System.out.println(str.length()); // 5

        // 문자열 결합
        System.out.println(str.concat(" is red")); // apple is red
        System.out.println(str + " is red"); // apple is red

        // 문자열 비교
        System.out.println("apple".equals(str)); // true
        String str2 = "apple";
        System.out.println(str == str2); // true

        // 문자열 위치
        System.out.println(str.indexOf("p")); // 1
        System.out.println(str.indexOf("z")); // -1 (없으면 -1)
        System.out.println(str.indexOf("p", 2)); // 2번째부터 찾기
        System.out.println(str.lastIndexOf("p")); // 2 (뒤에서부터 찾기)

        // 문자열 자르기
        System.out.println(str.substring(1)); // pple
        System.out.println(str.substring(1, 3)); // pp

        // 문자열 바꾸기
        System.out.println(str.replace("p", "P")); // aPPle (모든 p를 P로 바꾸기)
        System.out.println(str.replaceFirst("p", "P")); // aPple (첫번째 p를 P로 바꾸기)
        System.out.println(str.replaceAll("p", "P")); // aPPle (정규식을 사용하여 모든 p를 P로 바꾸기)

        // 문자열 분리
        String[] arr = "apple is red".split(" ");
        for (String s : arr) {
            System.out.println(s);
        }
        // apple
        // is
        // red

        // 문자열 공백 제거
        System.out.println("   apple   ".trim()); // apple

        // 문자열 대소문자 변환
        System.out.println("apple".toUpperCase()); // APPLE
        System.out.println("APPLE".toLowerCase()); // apple

        // 문자열 포맷팅
        System.out.println(String.format("%s is red", "apple")); // apple is red
        System.out.println(String.format("%d is red", 1)); // 1 is red

        // 문자열을 숫자로 변환
        System.out.println(Integer.parseInt("1")); // 1
        System.out.println(Double.parseDouble("1.1")); // 1.1

        // 숫자를 문자열로 변환
        System.out.println(String.valueOf(1)); // 1
        System.out.println(String.valueOf(1.1)); // 1.1

        // 문자열을 문자 배열로 변환
        char[] arr2 = "apple".toCharArray();
        for (char c : arr2) {
            System.out.println(c);
        }
        // a
        // p
        // p
        // l
        // e

        // isBlank vs isEmpty
        System.out.println("".isBlank()); // true
        System.out.println(" ".isBlank()); // true
        System.out.println("".isEmpty()); // true
        System.out.println(" ".isEmpty()); // false

        // 문자열이 특정 문자열로 시작하는지 확인
        System.out.println("apple".startsWith("a")); // true
        System.out.println("apple".startsWith("b")); // false

        // 문자열이 특정 문자열로 끝나는지 확인
        System.out.println("apple".endsWith("e")); // true
        System.out.println("apple".endsWith("a")); // false

        // 문자열이 특정 문자열을 포함하는지 확인
        System.out.println("apple".contains("p")); // true

        // 문자열이 특정 문자열을 포함하는지 확인 (정규식 사용)
        System.out.println("apple".matches(".*p.*")); // true
        System.out.println("apple".matches(".*b.*")); // false
    }
}