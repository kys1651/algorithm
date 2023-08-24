import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        
        int time = 0;
        int total_weight = 0;
        for(int truck : truck_weights){
            
            while(true){
                
                // 큐가 비어있을 때(다리에 트럭이 없을 때)
                if(q.isEmpty()){
                    // 값을 넣어 준 뒤 시간에 1을 더한 후 break;
                    q.offer(truck);
                    total_weight += truck;
                    time++;
                    break;
                }
                // 큐의 사이즈(다리에 있는 차에 대수)와 길이가 같을 때
                else if(q.size() == bridge_length){
                    // 값을 빼주고 time을 증가 안하는 이유는 초과할 때 
                    // 0을 넣어주고 time에 1을 더해주기 때문에
                    total_weight -= q.poll();
                }
                else{
                    // 다음 트럭이 올 수 있는 경우
                    if(total_weight + truck <= weight){
                        q.offer(truck);
                        total_weight += truck;
                        time++;
                        break;
                    }else{
                        // 다음 트럭이 무게를 초과해서 오지 못하는 경우 0을 넣어주고 time을 증가해줌
                        q.offer(0);
                        time++;
                    }
                }
            }
        }
        // 마지막 트럭을 큐에 올려둔 뒤 while문이 break된다.
        // 그러므로 다리의 길이만큼 더해주어야한다.
        return time + bridge_length;
    }
}