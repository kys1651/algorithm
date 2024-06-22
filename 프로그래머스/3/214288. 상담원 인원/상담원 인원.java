import java.util.*;

class Solution {
    static ArrayList<int[]>[] reqList;
    static int[][] memo;
    
    public int solution(int k, int n, int[][] reqs) {
        reqList = new ArrayList[k+1];
        int[] mento = new int[k+1];
        for(int i = 1;i <= k; i++){
            mento[i] = 1;
            reqList[i] = new ArrayList();
        }
        
        for(int i = 0; i < reqs.length; i++){
            reqList[reqs[i][2]].add(new int[]{reqs[i][0],reqs[i][1]});
        }
        
        int max = n - k + 1;
        memo = new int[k+1][max+1];
        for(int i = 1; i <= k; i++){
            for(int j = 1; j <= max; j++){
                memo[i][j] = getTime(i,j);
            }
        }        
        
        int[] idx = new int[k+1];
        for(int i = 1; i <= k ; i++){
            idx[i] = 1;
        }
        
        int count = n - k;
        while(count != 0){
            int maxTime = Integer.MIN_VALUE;
            int minIdx = 0;
            for(int i = 1; i <= k; i++){
                if(idx[i] == max) continue;
                int time = memo[i][idx[i]] - memo[i][idx[i]+1];
                if(maxTime < time){
                    maxTime = time;
                    minIdx = i;
                }
            }
            idx[minIdx]++;
            count--;
        }
        
        int answer = 0;
        for(int i = 1; i <= k; i++){
            answer += memo[i][idx[i]];
        }
        
        return answer;
    }
    
    private static int getTime(int x, int y){
        int size = reqList[x].size();
        if(size == 0) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < y; i++) pq.add(0);
        
        int time = 0;
        for(int[] req : reqList[x]){
            
            if(req[0] >= pq.peek()){
                pq.poll();
                pq.add(req[0] + req[1]);
            }
            else{
                time += pq.peek() - req[0];
                pq.add(pq.poll() + req[1]);
            }
        }
        return time;
    }
}