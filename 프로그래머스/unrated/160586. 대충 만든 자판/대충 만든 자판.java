import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length(); j++){
                char ch = keymap[i].charAt(j);
                
                if(map.containsKey(ch)){
                    if(j + 1 < map.get(ch)){
                        map.put(ch,j+1);
                    }
                }else{
                    map.put(ch,j+1);
                }
            }
        }
        for(int i = 0 ; i < targets.length; i++){
            int count = 0;
            
            for(char ch : targets[i].toCharArray()){
                if(map.containsKey(ch)){
                    count += (map.get(ch));
                }else{
                    count = -1;
                    break;
                }
            }
            
            answer[i] = count;
        }
        
        
        return answer;
    }
}