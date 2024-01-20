class StringBuilderEx {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("apple");

        // 길이
        System.out.println(sb.length()); // 5

        // 문자열 결합
        System.out.println(sb.append(" is red")); // apple is red

        // 문자열 삽입
        System.out.println(sb.insert(0, "apple is ")); // apple is apple is red

        // 문자열 삭제
        System.out.println(sb.delete(0, 11)); // red

        // 특정 문자 삭제
        System.out.println(sb.deleteCharAt(0)); // ed

        // 문자열 뒤집기
        System.out.println(sb.reverse()); // de

        // 문자열 비교
        System.out.println("apple".equals(sb.toString())); // false

        // 문자열 위치
        System.out.println(sb.indexOf("e")); // 1

        // 문자열 자르기
        System.out.println(sb.substring(1)); // e

        // 문자열 절대 길이 줄이기
        sb.append("apple"); // eapple
        sb.setLength(3); // eap

        // 문자열 절대 길이 늘리기
        sb.setLength(4); // "eap "
    }
}
