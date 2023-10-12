import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < s.length(); i++){
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if(isCheck(sb.toString()))
                answer++;
        }
        return answer;
    }
    
    public boolean isCheck(String s){
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && match(ch, stack.peek())){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    
    public boolean match(char cur, char prev){
        return (cur == ')' && prev == '(') || (cur == ']' && prev == '[') || (cur == '}' && prev == '{');
    }
}