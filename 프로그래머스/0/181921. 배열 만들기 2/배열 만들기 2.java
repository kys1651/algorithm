import java.util.*;

class Solution {
    private static PriorityQueue<Integer> answer = new PriorityQueue<>((o1,o2) -> o1 - o2);
    public int[] solution(int l, int r) {
        solve(l,r,5);
        System.out.println(answer);
        if(answer.isEmpty()){
            return new int[] {-1};
        }
        int size = answer.size();
        int[] ret = new int[size];
        for(int i = 0; i < size; i++){
            ret[i] = answer.poll();
        }
        return ret;
    }
    private static void solve(int left, int right, int value){
        if(value > right) return;
        if(left <= value && value <= right){
            answer.add(value);
        }
        solve(left, right, value * 10 + 5);
        solve(left, right, value * 10);
    }
}