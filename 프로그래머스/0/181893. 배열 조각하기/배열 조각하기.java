class Solution {
    public int[] solution(int[] arr, int[] query) {
        int left = 0, right = arr.length;
        for(int i = 0;i < query.length; i++){
            if(i % 2 == 0) right = left + query[i];
            else left += query[i];
        }

        int[] answer = new int[right - left + 1];
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr[left + i];
        }
        return answer;
    }
}