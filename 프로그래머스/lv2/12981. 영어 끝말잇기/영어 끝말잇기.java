import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> check = new HashSet<>();

        String prev = "";
        for(int i = 0; i < words.length/n; i++){
            for(int j = 0; j < n; j++){
                int idx = i * n + j;
                if(idx == 0){
                    prev = words[idx];
                    check.add(prev);
                    continue;
                }
                
                if(check.contains(words[idx]) || words[idx].charAt(0) != prev.charAt(prev.length()-1)){
                    return new int[] {j+1, i+1};
                }else{
                    check.add(words[idx]);
                    prev = words[idx];
                }
            }
        }

        return new int[] {0,0};
    }
}