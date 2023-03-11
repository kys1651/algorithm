import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int size = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i]%divisor==0){
                size++;
            }else{
                arr[i] = 0;
            }
        }
        int[] answer = new int[size==0?1:size];
        answer[0] = -1;
        Arrays.sort(arr);
        for(int i = 0,idx = 0 ; i < arr.length; i++){
            if(arr[i]!=0) answer[idx++] = arr[i]; 
        }
        return answer;
    }
}