import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        
        int len = numbers.length;
        int[] answer = new int[len];
        
        for(int i = len - 1; i >= 0; i--){
            int val = numbers[i];
            while(!stack.isEmpty() && stack.peek() <= val) stack.pop();
            
            if(stack.isEmpty()) answer[i] = -1;
            else answer[i] = stack.peek();
            stack.push(val);
        }
        
        return answer;
    }
}