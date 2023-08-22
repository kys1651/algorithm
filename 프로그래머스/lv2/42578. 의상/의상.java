import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int result = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < clothes.length; i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int value = map.get(key);
            result *= (value + 1);
        }
        
        return result-1;
    }
}