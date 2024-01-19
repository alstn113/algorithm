import java.util.StringJoiner;

class StringJoinerEx {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add("apple");
        sj.add("banana");
        sj.add("orange");

        // 문자열 결합
        System.out.println(sj.toString()); // [apple, banana, orange]

        // 문자열 결합
        StringJoiner sj2 = new StringJoiner(", ");
        sj2.add("apple");
        sj2.add("banana");
        sj2.add("orange");

        System.out.println(sj2.toString()); // apple, banana, orange
    }
}
