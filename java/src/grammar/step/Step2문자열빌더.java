package grammar.step;

public class Step2문자열빌더 {

    public static void main(String[] args) {
        // 문자열 추가
        StringBuilder sb = new StringBuilder();
        sb.append("apple");
        sb.insert(2, "banana"); // 2번 인덱스에 "banana" 삽입
        System.out.println(sb); // applebanana

        // 문자열 삭제
        sb.delete(2, 8); // 2번 인덱스부터 8번 인덱스 전까지 삭제
        System.out.println(sb); // apple
        sb.deleteCharAt(0); // 0번 인덱스 문자 삭제
        System.out.println(sb); // pple

        // 문자열 변경
        sb.replace(0, 2, "kiwi"); // 0번 인덱스부터 2번 인덱스 전까지 "kiwi"로 변경
        System.out.println(sb); // kiwiple
        sb.setCharAt(0, 'a'); // 0번 인덱스 문자를 'a'로 변경
        System.out.println(sb); // aiwiple

        // 문자열 길이
        System.out.println(sb.length()); // 7

        // 문자열 뒤집기
        sb.reverse(); // 문자열 뒤집기
        // String a = new StringBuilder("apple").reverse(); // apple -> elppa

        // 문자열 절대 길이 줄이기
        sb.setLength(5); // 길이를 5로 줄이기

        // 실전
        String input = "apple";
        StringBuilder sb2 = new StringBuilder(input);
        sb2.reverse(); // 문자열 뒤집기
        String output = sb2.toString();
        System.out.println(output); // elppa
    }
}
