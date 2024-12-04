import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // topping의 길이가 n이라 할 때 O(n)만큼을 먼저 돌아서 Right 해시맵에 넣는다.
        HashMap<Integer, Integer> right = getRightHashMap(topping);
        
        HashMap<Integer, Integer> left = new HashMap<>();
        // 1. 모든 원소를 비교한다.
        int answer = 0;
        for(int t : topping){
        // 2. 각 원소를 현재 Left 해시맵에 추가하고, Right해시맵에 값이 0이면 키값을 제거한다.
            left.put(t, left.getOrDefault(t,0) + 1);
            int value = right.get(t);
            if(value == 1){
                right.remove(t);
            }else{
                right.put(t, value - 1);
            }
            
            // 3. 만약 해당 해시맵의 사이즈가 같다면 answer을 증가한다. 
            if(left.size() == right.size()){
                answer++;
            }
        }
        return answer;
    }
    
    private static HashMap<Integer, Integer> getRightHashMap(int[] topping){
        HashMap<Integer, Integer> right = new HashMap<>();
        for(int t: topping){
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        return right;
    }
}