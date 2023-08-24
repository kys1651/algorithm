import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 내림차순으로 우선순위 큐 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        //
        for(int priority : priorities){
            pq.offer(priority);
        }
        
        while(!pq.isEmpty()){
            for(int i = 0 ; i < priorities.length;i++){
                // 전부 확인해준 뒤 우선 순위 큐에 가장 첫번째 값과 같은지 확인
                if(priorities[i] == pq.peek()){
                    // i와 location이 같다면 +1 후 리턴 해줌
                    if(i == location){
                        answer++;
                        return answer;
                    }
                    // 같지 않다면 제거 한뒤 answer을 1 증가
                    pq.remove();
                    answer++;
                }
            }
        }
        return answer;
    }
}