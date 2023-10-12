import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        
        while(len --> 0){
            sb.append(sb.charAt(0));
            sb.delete(0,1);
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
        
        while(!stack.isEmpty()){
            char ch = stack.pop();
            if(!stack.isEmpty() && match(ch,stack.peek())){
                stack.pop();
            }else{
                return false;
            }
        }
        return true;
    }
    
    public boolean match(char cur, char prev){
        return (cur == ')' && prev == '(') || (cur == ']' && prev == '[') || (cur == '}' && prev == '{');
    }
}