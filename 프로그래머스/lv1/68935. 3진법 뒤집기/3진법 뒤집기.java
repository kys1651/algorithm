class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder(numtosam(n));
        int answer = samtonum(sb.reverse().toString());
        
        System.out.println(answer);
        
        return answer;
    }
    
    public String numtosam(int n){
        String str = "";
        
        int num = 3;
        while(n != 0){
            str = String.valueOf(n % 3) + str;
            n /= 3;
        }
        return str;
    }
    
    public int samtonum(String str){
        int answer = 0;
        int digit = 1;
        for(int i = str.length()-1; i >= 0; i--){
            char ch = str.charAt(i);
            answer += digit * (ch - '0');
            digit *= 3;
        }
        return answer;
    }
}