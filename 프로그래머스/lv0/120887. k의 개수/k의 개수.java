class Solution {
    public int solution(int i, int j, int k) {
        String answer = "";
        
        for(; i<= j ; i++){
            answer += i+"";
        }
        return answer.length() - answer.replace(k+"","").length();
    }
}