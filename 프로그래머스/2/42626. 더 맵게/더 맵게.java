import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville){
            pq.add(scov);
        }
        
        int answer = 0;
        while(!pq.isEmpty() && pq.peek() < K){
            int a = pq.poll();
            if(pq.isEmpty()){
                answer = -1;
                break;
            }
            pq.add(a + pq.poll() * 2);
            answer++;
        }
        
        return answer;
    }
}