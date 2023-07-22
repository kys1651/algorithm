import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        return IntStream.of(arr)
            .map(n -> k % 2 == 0 ? n + k : n * k)
            .toArray();
    }
}