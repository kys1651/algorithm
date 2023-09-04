class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        int len = my_string.length() - overwrite_string.length() - s;
        String answer = my_string.substring(0,s) + overwrite_string;
        if(len > 0) answer += my_string.substring(my_string.length() - len);
        return answer;
    }
}