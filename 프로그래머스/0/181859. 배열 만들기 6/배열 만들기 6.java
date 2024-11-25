import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        int size = 0, i = 0;
        for(; i != arr.length;){
            if(stack.isEmpty()){
                stack.push(arr[i++]);
            }else if(stack.peek() == arr[i]){
                i++;
                stack.pop();
            }else if(stack.peek() != arr[i]){
                stack.push(arr[i++]);
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