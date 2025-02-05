package algorithm.이진_탐색;

public class 이진_탐색 {

    static int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    // 이진 탐색 - 시간 복잡도 O(logN)
    // 참고: 자바의 Arrays.binarySearch(), Collections.binarySearch() 메서드를 사용할 수 있다.
    public static void main(String[] args) {
        int target = 7;
        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("찾고자 하는 대상이 존재하지 않습니다.");
        } else {
            System.out.println("찾고자 하는 대상의 인덱스는 " + result + "입니다.");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
