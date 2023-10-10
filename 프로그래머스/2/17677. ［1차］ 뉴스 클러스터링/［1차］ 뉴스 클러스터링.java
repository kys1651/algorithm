import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String,Integer> map1 = getMap(str1.toLowerCase());
        Map<String,Integer> map2 = getMap(str2.toLowerCase());
        
        double intersection = (double)getIntersection(map1, map2);
        double union = (double)getUnion(map1, map2);
        if(intersection + union == 0){
            return 65536;
        }
        
        return (int)(intersection / union * 65536);
    }
    
    public int getUnion(Map<String,Integer> map1, Map<String,Integer> map2){
        int union = 0;
        for(String key : map1.keySet()){
            int value1 = map1.get(key);
            
            if(!map2.containsKey(key)){
                union += value1;
            }else{
                union += Math.max(value1, map2.get(key));
            }
        }
        
        for(String key : map2.keySet()){
            if(!map1.containsKey(key)){
                union += map2.get(key);
            }
        }
        
        return union;
    }
    
    public int getIntersection(Map<String,Integer> map1, Map<String,Integer> map2){
        int intersection = 0;
        
        if(map1.size() == 0 || map2.size() == 0){
            return intersection;
        }
        for(String key : map1.keySet()){
            if(!map2.containsKey(key)){
                continue;
            }
            
            int value1 = map1.get(key);
            int value2 = map2.get(key);
            
            intersection += Math.min(value1,value2);
        }
        
        return intersection;
    }
    
    public Map<String,Integer> getMap(String str){
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < str.length() - 1; i++){
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i+1);
            
            if(ch1 < 'a' || ch1 > 'z' || ch2 < 'a' || ch2 > 'z')
                continue;
            
            String tmp = "" + ch1 + ch2;
            map.put(tmp, map.getOrDefault(tmp,0) + 1);
        }
        
        return map;
    }
}