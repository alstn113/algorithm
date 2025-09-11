import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        Set<List<Integer>> result = new HashSet<>();

        for (int[] bf : build_frame) {
            int col = bf[0];
            int row = bf[1];
            int a = bf[2]; // 0은 기둥, 1은 보
            int b = bf[3]; // 0은 삭제, 1은 설치

            if (b == 1) {
                if (a == 0) {
                    // 기둥 설치
                    if (row == 0 // 바닥
                            || result.contains(List.of(col - 1, row, 1)) // 왼쪽 보
                            || result.contains(List.of(col, row, 1)) // 오른쪽 보
                            || result.contains(List.of(col, row - 1, 0)) // 아래 기둥
                    ) {
                        result.add(List.of(col, row, a));
                    }
                } else {
                    // 보 설치
                    if (result.contains(List.of(col, row - 1, 0)) // 왼쪽 아래 기둥
                            || result.contains(List.of(col + 1, row - 1, 0)) // 오른쪽 아래 기둥
                            || (result.contains(List.of(col - 1, row, 1)) && result.contains(List.of(col + 1, row, 1)))
                    ) {
                        result.add(List.of(col, row, a));
                    }
                }
            } else {
                // 1. 일단 삭제 처리
                // 연결된 구조들이 문제가 없는지 확인
                // 이것과 연결된 구조들이 문제가 없는지 확인
                // 하나라도 문제가 있으면 복구 처리
                // 이것을 재귀적으로 처리
                result.remove(List.of(col, row, a));
                if (!isPossible(result)) {
                    result.add(List.of(col, row, a));
                }
            }
        }
        
        List<List<Integer>> answer= new ArrayList<>();
        for (List<Integer> structure : result) {
            answer.add(structure);
        }
        answer.sort((o1, o2) -> {
            if (o1.get(0).equals(o2.get(0))) {
                if (o1.get(1).equals(o2.get(1))) {
                    return o1.get(2) - o2.get(2);
                }
                return o1.get(1) - o2.get(1);
            }
            return o1.get(0) - o2.get(0);
        });
        int[][] answerArr = new int[answer.size()][3];
        for (int i = 0; i < answer.size(); i++) {
            answerArr[i][0] = answer.get(i).get(0);
            answerArr[i][1] = answer.get(i).get(1);
            answerArr[i][2] = answer.get(i).get(2);
        }
        return answerArr;
    }
    
    public boolean isPossible(Set<List<Integer>> result) {
        for (List<Integer> structure : result) {
            int col = structure.get(0);
            int row = structure.get(1);
            int a = structure.get(2); 

            if (a == 0) {
              
                if (!(row == 0 
                        || result.contains(List.of(col - 1, row, 1)) 
                        || result.contains(List.of(col, row, 1)) 
                        || result.contains(List.of(col, row - 1, 0)) 
                )) {
                    return false;
                }
            } else {
                if (!(result.contains(List.of(col, row - 1, 0)) 
                        || result.contains(List.of(col + 1, row - 1, 0)) 
                        || (result.contains(List.of(col - 1, row, 1)) && result.contains(List.of(col + 1, row, 1)))
                )) {
                    return false;
                }
            }
        }
        return true;
    }
}