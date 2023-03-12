import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        int min = 0;
        int idx= 0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] < arr[min]) min = i;
        }
        int[] answer = new int[arr.length-1>0?arr.length-1:1];
        
        for(int i = 0 ; i < arr.length; i++){
            if(i != min) answer[idx++] = arr[i];
        }
        if(arr.length-1==0) answer[0] = -1;
        return answer;
    }

}