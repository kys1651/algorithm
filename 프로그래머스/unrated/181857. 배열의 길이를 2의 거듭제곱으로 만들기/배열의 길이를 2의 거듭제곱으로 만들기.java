import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int len;
        for(len = 1; len < arr.length; len *= 2){
        }
        int[] answer = new int[len];
        for(int i = 0; i < arr.length; i++){
            answer[i] = arr[i];
        }
        for(int i = arr.length; i < len; i++){
            answer[i] = 0;
        }
        return answer;
    }
}