import java.util.*;

class Solution {
    public int[] solution(int[] arr, int n) {
        int len = arr.length;
        int[] answer = Arrays.copyOf(arr,len);
        for(int i = 0; i < len; i++){
            if(len % 2 == 0){
                if(i % 2 !=0)
                    answer[i] += n;
            }else{
                if(i % 2 == 0)
                    answer[i] += n;
            }
        }
        return answer;
    }
}