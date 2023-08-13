import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        for(String str: my_string.trim().split(" ")){
            if(!str.trim().equals("")){
                list.add(str.trim());
            }
        }
        return list.toArray(new String[list.size()]);
    }
}