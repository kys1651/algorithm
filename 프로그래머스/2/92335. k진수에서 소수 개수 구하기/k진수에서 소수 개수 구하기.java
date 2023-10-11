class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String base = parse(n,k);
        
        for(String check : base.split("0")){
            if(check.equals(""))
                continue;
            
            if(isPrime(Long.valueOf(check))){
                
                answer++;
            }
                
        }
        return answer;
    }
    
    // 진법 변환 메서드
    public String parse(int n, int k){
        StringBuilder sb = new StringBuilder();
        
        while(n != 0){
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
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