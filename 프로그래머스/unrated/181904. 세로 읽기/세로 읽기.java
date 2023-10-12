class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < my_string.length() / m;i++){
            answer.append(my_string.charAt(m * i + c - 1));
        }
        
        return answer.toString();
    }
}