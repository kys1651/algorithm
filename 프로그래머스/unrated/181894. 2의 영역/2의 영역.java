class Solution {
    public int[] solution(int[] arr) {
        int start = Integer.MAX_VALUE;
        int last = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2){
                start = Math.min(start,i);
                last = Math.max(last,i);
            }
        }
        if(start == Integer.MAX_VALUE){
            return new int[] {-1};
        }
        int[] answer = new int[last - start + 1];
        for(int i = start; i <= last; i++){
            answer[i - start] = arr[i];
        }
        return answer;
    }
}