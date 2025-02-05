package grammar;

import java.util.*;

public class StringJoinerEx {

    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add("apple");
        sj.add("banana");
        sj.add("cherry");
        System.out.println(sj.toString()); // [apple, banana, cherry]

        StringJoiner sj2 = new StringJoiner(", ");
        sj2.add("apple");
        sj2.add("banana");
        sj2.add("cherry");
        System.out.println(sj2.toString()); // apple, banana, cherry

        StringJoiner sj3 = new StringJoiner(", ", "[", "]");
        sj3.setEmptyValue("empty"); // setEmptyValue()는 문자열이 비어있을 때 대신 출력할 문자열을 설정
        System.out.println(sj3.toString()); // empty
    }
}
