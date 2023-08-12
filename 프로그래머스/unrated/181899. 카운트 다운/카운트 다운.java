import java.util.stream.*;

class Solution {
    public int[] solution(int start, int end) {
        return IntStream.rangeClosed(end,start).map(i -> end + (start - i)).toArray();
    }
}