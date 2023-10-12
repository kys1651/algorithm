import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int idx = 0;
        int[] terms = new int[prices.length];
        
        beginIdxs.push(idx);
        for(idx = 1; idx < prices.length; idx++){
            while(!beginIdxs.empty() && prices[idx] < prices[beginIdxs.peek()]){
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = idx - beginIdx;
            }
            beginIdxs.push(idx);
        }
        
        while(!beginIdxs.empty()){
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = idx - beginIdx - 1;
        }
        
        return terms;
    }
}