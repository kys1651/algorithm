import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map1.containsKey(ch)){
                map1.put(ch,i);
                map2.put(ch,-1);
                
                answer[i] = -1;
            }
            else{
                map2.put(ch,i - map1.get(ch));
                map1.put(ch,i);
                
                answer[i] = map2.get(ch);
            }
        }
        
        return answer;
    }
}