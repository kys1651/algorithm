class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        for(String check : Integer.toString(n, k).split("0")){
            if(check.equals(""))
                continue;
            
            if(isPrime(Long.valueOf(check))){
                
                answer++;
            }
                
        }
        return answer;
    }
    
    // 소수 확인 메서드
    public boolean isPrime(long n){
        if(n == 1) return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}