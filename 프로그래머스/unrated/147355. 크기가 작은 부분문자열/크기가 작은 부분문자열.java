class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i = 0 ; i <= t.length()-p.length(); i++){
            Long n = Long.parseLong(t.substring(i,i+p.length()));
            if(Long.parseLong(p)>= n) answer++;
        }
        return answer;
    }
}