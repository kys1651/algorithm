import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        int answer = 0;
        List<String> cache = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            
            // cache의 크기가 아직 size보다 작을 때
            if(cache.size() < cacheSize){
                if(cache.contains(city)){
                    answer += 1;
                    cache.remove(city);
                }else{
                    answer += 5;
                }
                cache.add(city);
            }
            else{
                if(cache.contains(city)){
                    answer += 1;
                    cache.remove(city);
                }else{
                    answer += 5;
                    cache.remove(0);
                }
                cache.add(city);
            }
        }
        
        return answer;
    }
}