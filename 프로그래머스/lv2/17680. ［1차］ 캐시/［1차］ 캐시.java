import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        int hit = 0;
        int miss = 0;
        List<String> cache = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            
            // cache의 크기가 아직 size보다 작을 때
            if(cache.size() < cacheSize){
                if(cache.contains(city)){
                    cache.remove(city);
                    hit++;
                }else{
                    miss++;
                }
            }
            else{
                if(cache.contains(city)){
                    hit++;
                    cache.remove(city);
                }else{
                    miss++;
                    cache.remove(0);
                }
            }
            cache.add(city);
        }
        
        return hit + miss * 5;
    }
}