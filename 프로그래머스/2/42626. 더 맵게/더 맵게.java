import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville){
            pq.add(scov);
        }
        
        int answer = 0;
        while(true){
            if(pq.isEmpty() || pq.peek() >= K) break;
            int a = pq.poll();
            if(pq.isEmpty()){
                answer = -1;
                break;
            }
            int b = pq.poll();
            pq.add(a + b * 2);
            answer++;
        }
        
        return answer;
    }
}