import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizePerCount = new HashMap<>();
        for(int t : tangerine){
            sizePerCount.put(t, sizePerCount.getOrDefault(t,0)+1);
        }
        
        List<Integer> sizeCount = new ArrayList<>(sizePerCount.values());
        Collections.sort(sizeCount, (o1,o2) -> o2 - o1 );
        
        int n = 0;
        int sumCount = 0;
        for(int count : sizeCount){
            sumCount += count;
            n++;
            
            if(k <= sumCount)
                break;
        }
        
        return n;
    }
}