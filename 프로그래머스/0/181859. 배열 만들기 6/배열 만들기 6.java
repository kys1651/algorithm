import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i != arr.length; i++){
            if(stack.isEmpty() || stack.peek() != arr[i]){
                stack.push(arr[i]);
            }else if(stack.peek() == arr[i]){
                stack.pop();
            }
        }
        
        if(stack.isEmpty()){
            return new int[]{-1};
        }
        int idx = stack.size();
        int[] ret = new int[idx];
        while(!stack.isEmpty()){
            ret[--idx] = stack.pop();
        }
        return ret;
    }
}