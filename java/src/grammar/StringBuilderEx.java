package grammar;

public class StringBuilderEx {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // 문자열 추가
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");

        // 문자열 추가 (체이닝)
        sb.append("Hello").append(" ").append("World");

        // 문자열 추가 (중간에)
        sb.insert(5, " Java"); // Hello Java World

        // 문자열 삭제
        sb.delete(5, 10); // Hello World (5번째 인덱스부터 10번째 인덱스 전까지 삭제)

        // 문자열 대체
        sb.replace(6, 11, "Java"); // Hello Java World (6번째 인덱스부터 11번째 인덱스 전까지 대체)

        // 문자열 반전
        sb.reverse(); // dlroW avaJ olleH

        // 문자열 인덱스 삭제
        sb.deleteCharAt(0); // lroW avaJ olleH

        // 문자열 길이
        System.out.println(sb.length()); // 15

        // 문자열 길이 조정
        sb.setLength(5); // "lroW"
        sb.setLength(6); // "lroW " (공백 1개 추가)
    }
}
