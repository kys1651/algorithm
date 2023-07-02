import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < name.length; i++){
            map.put(name[i],yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++){
            String[] persons = photo[i];
            
            for(String person : persons){
                if(map.containsKey(person)){
                    answer[i] += map.get(person);
                }
            }
        }
        return answer;
    }

}