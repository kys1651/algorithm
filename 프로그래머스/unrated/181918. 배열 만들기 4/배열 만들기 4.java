class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int idx = -1;
        for(int i = 0; i< arr.length; i++){
            while(idx >= 0 && stk[idx] >= arr[i]){
                idx--;
            }
            stk[++idx] = arr[i];
        }
        int[] answer = new int[idx+1];
        for(int i = 0; i < answer.length; i++){
            answer[i] = stk[i];
        }
        return answer;
    }
}