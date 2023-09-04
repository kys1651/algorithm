class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String check = s.toLowerCase();
        
        boolean flag = true;
        for(char ch : check.toCharArray()){
            sb.append(flag ? Character.toUpperCase(ch) : ch);
            flag = ch == ' '?true : false;
        }
        
        return sb.toString();
    }
}