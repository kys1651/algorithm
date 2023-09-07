class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n ; i++){
            if(check(i,n)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean check(int start, int goal){
        int result = 0;
        
        for(int i = start; i <= goal; i++){
            result += i;
            if(result > goal){
                return false;
            }else if(result == goal){
                break;
            }
        }
        return true;
    }
}