import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_입력 {

    public static void main(String[] args) throws IOException {
        // 문자열 입력
        String str = readString();
        System.out.println(str);

        // 숫자 입력
        int n = readInt();
        System.out.println(n);

        // 숫자 배열 입력
        int[] arr = readIntArray(n);
        System.out.println(Arrays.toString(arr));

        // 숫자 리스트 입력
        List<Integer> list = readIntList();
        System.out.println(list);
    }

    // 한 줄로 입력 받는 문자열
    public static String readString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return br.readLine();
    }

    // 한 줄로 입력 받는 숫자
    public static int readInt() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return Integer.parseInt(br.readLine());
    }

    // 한 줄에 공백으로 구분된 숫자들
    public static int[] readIntArray(int n) throws IOException {
        int[] arr = new int[n];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        return arr;
    }

    // 무한히 입력 받는 경우
    public static List<Integer> readIntList() throws IOException {
        List<Integer> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        return list;
    }
}
