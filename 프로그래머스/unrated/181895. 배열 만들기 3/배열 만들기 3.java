import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        
        for(int[] interval: intervals){
            int idx = interval[0];
            int max = interval[1];
            
            for(; idx <= max; idx++){
                list.add(arr[idx]);
            }
        }
        
        int [] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}