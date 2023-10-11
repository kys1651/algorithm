class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] tmp = Integer.toString(n, k).split("0");
        
        Loop: for(String check : tmp){
            if(check.length() == 0) continue;
            long a = Long.valueOf(check);
            if(a == 1) continue;
            for(int i = 2; i <= Math.sqrt(a); i++)
                if(a % i == 0) continue Loop;
            
            answer++;    
        }
        return answer;
    }
}