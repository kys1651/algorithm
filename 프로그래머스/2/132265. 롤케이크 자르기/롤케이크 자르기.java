import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int[] right = new int[10001], left = new int[10001];
        int rC = 0, lC = 0, answer = 0;
        for(int t : topping) right[t]++;
        for(int c : right) rC += c == 0 ? 0 : 1;
        for(int t : topping){
            if(right[t]-- == 1) rC--;
            if(left[t]++ == 0) lC++;
            if(rC == lC) answer++;
        }
        return answer;
    }
}