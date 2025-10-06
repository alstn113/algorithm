class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int di = n-1;
        int pi = n-1;
        long result = 0;
        
        while(true) {
            // 마지막 인덱스에서 시작해서 0보다 큰 수가 나올 때까지 줄임. 
            while(di > -1 && deliveries[di] == 0) {
                di -= 1;
            }
            while(pi > -1 && pickups[pi] == 0) {
                pi -= 1;
            }
            
            // 둘 다 -1이면 카운팅하지 않음.    
            if (di == -1 && pi == -1) {
                break;
            }
            
            // delivery와 pickup의 최대 값 * 2를 result에 더하기.
            int v = Math.max(di, pi) + 1;
            result += v * 2;
            
            // cap 만큼 줄이기.
            int dcap = cap;
            while(di > -1 && dcap > 0) {
                if (deliveries[di] > dcap) {
                    deliveries[di] -= dcap;
                    break;
                } else {
                    dcap -= deliveries[di];
                    deliveries[di] = 0;
                    di -= 1;
                }
            }
            
            int pcap = cap;
            while(pi > -1 && pcap > 0) {
                if (pickups[pi] > pcap) {
                    pickups[pi] -= pcap;
                    break;
                } else {
                    pcap -= pickups[pi];
                    pickups[pi] = 0;
                    pi -= 1;
                }
            }
        }
        
        return result;
    }
}