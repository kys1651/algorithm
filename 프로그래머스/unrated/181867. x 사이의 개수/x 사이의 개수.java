import java.util.stream.*;

class Solution {
    public int[] solution(String myString) {
        return Stream.of(myString.split("x",-1)).mapToInt(i -> i.length()).toArray();
    }

}