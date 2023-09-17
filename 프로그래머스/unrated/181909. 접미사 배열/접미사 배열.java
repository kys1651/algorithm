import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        Set<String> set = new TreeSet<>();
        
        for(int i = 0; i < my_string.length(); i++){
            set.add(my_string.substring(i));
        }
        // `
        return set.toArray(new String[0]);
    }
}