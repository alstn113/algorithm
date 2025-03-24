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

---

동일한 집합에 대해서 중복 제거 Set<Set<String>> 으로 가능

---
