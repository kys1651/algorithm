import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        String[] answer = Arrays.stream(myStr.replaceAll("[abc]", " ").split(" ")).filter(x -> !x.isEmpty()).toArray(String[]::new);
        if(answer.length == 0) return new String[] {"EMPTY"};
        else return answer;
    }
}