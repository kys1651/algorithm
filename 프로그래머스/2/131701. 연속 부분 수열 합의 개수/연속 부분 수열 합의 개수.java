import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j ++){
                int result = 0;
                
                for(int k = 0; k < i; k++){
                    if(j + k >= elements.length){
                        result += elements[j + k - elements.length];
                    }else{
                        result += elements[j+k];
                    }
                }
                
                set.add(result);
                
            }
        }
        return set.size();
    }
}