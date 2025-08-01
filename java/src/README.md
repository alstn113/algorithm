# 알고리즘 팁

Map.Entry<String, String> entry : a.entrySet()

---

Int[] 복사 Arrays.copyOfRange(arr, startIndex, endIndex);
정렬 compareTo
List 부분 자르기 aList.subList(startIndex, endIndex);
Split 후 Integer[]로 변경

---

Integer.toString(10, 2) 10을 2진수로
String 비교는 compareTo로 해야함.

---

int[]를 Integer[]로 변환
Integer[] integerArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

---

List<String>을 String[]으로 변환
String[] arr = Arrays.stream(strList).toArray(String[]::new);

---

문자열 정렬
String a = “BAC”;
char[] charArr = a.toCharArray();
Arrays.sort(charArr);
a = new String(charArr);

---

여러 값 비교 힘들 때 문자열로 조합해서 비교하기!

---

map에서 값으로 정렬하고 키를 얻는 방법 - 키로 리스트 만들고, map으로 정렬
List<String> sortedList = new ArrayList<>(maxMap.keySet());
sortedList.sort((o1, o2) -> maxMap.get(o2) - maxMap.get(o1));

---

a를 b로 나누고 올림한 값 -> (a + b - 1) / b
특정 개수를 세기 위한 값 10장씩 읽을 때 40장은 4장, 48장은 5장
---

동일한 집합에 대해서 중복 제거 Set<Set<String>> 으로 가능

---

문자 <-> 숫자 쉽게 변환
ex) char c = '3'; int num = c - '0'; // num = 3
ex) int num = 3; char c = (char) (num + '0'); // c = '3'

---

정수 타입 리스트 정렬 후 정수 배열로 변환
int[] arr = list.stream().sorted().mapToInt(i -> i).toArray();

---

키를 기준으로 정렬하고, 값을 가져오기
값으로 정렬하고 키를 가져올 수 있음.
```java
dic.entrySet().stream()
    .sorted((o1, o2) -> o2.getValue() - o1.getValue())
    .map(Entry::getKey)
    .mapToInt(k -> k)
    .toArray();
```
