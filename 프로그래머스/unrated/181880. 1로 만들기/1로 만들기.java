class Solution {
    public int solution(int[] num_list) {
        int[] divide = new int[31];
        divide[2] = 1;
        for(int i = 3; i <= 30;i++){
            if(i % 2 == 0) divide[i] = divide[i/2] + 1;
            else divide[i] = divide[i-1];
        }
        int answer = 0;
        for(int num : num_list){
            answer += divide[num];
        }
        return answer;
    }
}