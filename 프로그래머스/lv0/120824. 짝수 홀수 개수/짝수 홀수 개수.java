class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {0,0};
        int a = 0;
        int b = 0;
        
        for(int n : num_list){
            if(n%2==0) a++;
            else b++;
        }
        answer[0] = a;
        answer[1] = b;
        return answer;
    }
}