import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> check = new HashSet<>();

        char end = words[0].charAt(words[0].length()-1);
        check.add(words[0]);
        for(int i = 1; i < words.length; i++){
            char start = words[i].charAt(0);
            
            if(check.contains(words[i]) || start != end){
                return new int[] {(i % n)+1 , (i / n)+1};
            }
            end = words[i].charAt(words[i].length() - 1);
            check.add(words[i]);    
        }

        return new int[] {0,0};
    }
}