## **1. 입력 크기별 적절한 시간 복잡도**

일반적으로 코딩테스트는 1초에 약 **10⁷ ~ 10⁸번**의 연산을 처리할 수 있다고 가정합니다.

| 입력 크기(N) | 적절한 시간 복잡도 | 해결 유형                                    |
| ------------ | ------------------ | -------------------------------------------- |
| N ≤ 10       | O(N!) , O(2^N)     | 완전 탐색(브루트포스), 백트래킹              |
| N ≤ 20       | O(2^N)             | 비트마스킹, 백트래킹, 동적 계획법(부분 집합) |
| N ≤ 100      | O(N³)              | 플로이드-워셜, 삼중 루프 탐색                |
| N ≤ 1,000    | O(N²)              | 버블 정렬, 삽입 정렬, 플로이드-워셜          |
| N ≤ 10만     | O(N log N)         | 병합 정렬, 퀵 정렬, 이진 탐색, 세그먼트 트리 |
| N ≤ 1억      | O(N)               | 선형 탐색, 투 포인터, 해시                   |
| N ≥ 10억     | O(1)               | 상수 시간 연산                               |

---

## **2. 입력 크기별 해결 방법 예시**

### **1) N ≤ 10 : 완전 탐색, 백트래킹 (O(N!), O(2^N))**

- 가능한 모든 경우를 다 시도해도 되는 크기.
- **예제**: 순열, 조합 생성 / N-Queen 문제 / 외판원 순회(TSP)
- **해결 방법**: 백트래킹, 비트마스킹

### **2) N ≤ 20 : 부분 집합 탐색 (O(2^N))**

- 모든 부분 집합을 고려해야 하는 문제들
- **예제**: 부분 수열의 합 / 외판원 문제 (가지치기)
- **해결 방법**: DFS, 비트마스킹

### **3) N ≤ 100 : 삼중 루프 가능 (O(N³))**

- 플로이드-워셜처럼 3중 루프를 돌려도 문제없는 크기
- **예제**: 그래프의 모든 쌍 최단 경로 / 브루트포스
- **해결 방법**: 플로이드-워셜, 단순 3중 for문

### **4) N ≤ 1,000 : 이중 루프 가능 (O(N²))**

- 버블 정렬, 삽입 정렬 같은 단순 이중 루프 알고리즘이 가능
- **예제**: 거품 정렬 / 삽입 정렬 / DP (O(N²))
- **해결 방법**: 다이나믹 프로그래밍, 그래프 탐색

### **5) N ≤ 100,000 : 로그 시간 활용 (O(N log N))**

- 정렬, 이진 탐색, 세그먼트 트리 등 활용
- **예제**: 퀵 정렬, 병합 정렬 / 최장 증가 부분 수열 (LIS)
- **해결 방법**: 이진 탐색, 세그먼트 트리

### **6) N ≤ 10⁷ : 선형 알고리즘 (O(N))**

- 선형 탐색, 투 포인터, 슬라이딩 윈도우
- **예제**: 투 포인터를 활용한 연속 부분 합 / 슬라이딩 윈도우
- **해결 방법**: 해시, 큐, 덱, 투 포인터

### **7) N ≥ 10⁸ : 상수 시간 (O(1))**

- 단순한 수학적 공식이나 해시 맵을 이용
- **예제**: 정수 연산, 비트 연산, 해시 검색
- **해결 방법**: 수학 공식을 활용한 계산

---

## **3. 최적화 아이디어**

1. **완전 탐색 -> 가지치기 (백트래킹, DP)**
   - 예: 백트래킹을 이용한 N-Queen, 가지치기 적용한 DFS
2. **이중 루프 -> 해시, 투 포인터 활용**
   - 예: O(N²) 탐색을 O(N log N) 또는 O(N)으로 최적화
3. **정렬 및 이진 탐색 활용**
   - 예: 이분 탐색을 사용하여 O(N log N)으로 줄이기
4. **메모이제이션 (DP) 사용**
   - 예: 피보나치 수열을 O(2^N) → O(N)으로 개선
