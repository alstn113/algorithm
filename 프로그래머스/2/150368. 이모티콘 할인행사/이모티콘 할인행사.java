import java.util.*;

class Solution {
    
    List<List<Integer>> sales = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 이모티콘의 할인율에 따라서 구매 여부가 결정됨.
        // 특정 구매 금액을 넘으면 이모티콘 플러스를 구매함.
        // 이모티콘 플러스 사용자를 늘려야 함.
        // 결국 이모티콘 플러스 다음 매출액 순으로 결과를 모아야 함.
        // 이모티콘 할인율은 10 20 30 40
        
        // 모든 종류의 이모티콘 할인율 계산
        dfs(emoticons.length, new ArrayList<>());
        
        int plusCnt = 0;
        int saleAmount = 0;
        
        for (List<Integer> sale : sales) {
            int curPlus = 0;
            int curSaleAmount = 0;
            
            for (int[] user : users) {
                int sum = 0;
                int saleLimit = user[0];
                int saleAmountLimit = user[1];
                
                for (int i=0; i<emoticons.length; i++) {
                    if (sale.get(i) >= saleLimit) {
                        sum += emoticons[i] - emoticons[i] * sale.get(i) * 0.01; 
                    }                    
                }
                
                if (sum >= saleAmountLimit) {
                    curPlus += 1;
                } else {
                    curSaleAmount += sum;
                }
            }
            
            // 플러스 비교, 같으면 매출 비교
            if (curPlus > plusCnt) {
                plusCnt = curPlus;
                saleAmount = curSaleAmount;
            } else if (curPlus == plusCnt) {
                if (curSaleAmount > saleAmount) {
                    saleAmount = curSaleAmount;
                }
            }
        }
        
        return new int[] {plusCnt, saleAmount};
    }
    
    public void dfs(int n, List<Integer> cur) {
        if (cur.size() == n) {
            sales.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i=0; i<4; i++) {
            cur.add((i+1) * 10);
            dfs(n, cur);
            cur.remove(cur.size() - 1);
        }
    }
 }