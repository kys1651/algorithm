import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = speeds.length - 1; i >= 0 ; i --){
            int progress = 100 - progresses[i];
            int speed = speeds[i];
            int tmp = progress/speed;
            
            if(progress%speed > 0){
                tmp ++;
            }
            
            stack.push(tmp);
        }
        
        
        int idx = stack.pop();
        int tmp = 1;
        while(!stack.isEmpty()){
            int check = stack.pop();
            
            // System.out.print(idx + " " + check);
            if(check <= idx){
                // System.out.println(" skip");
                tmp++;
                continue;
            }
            
            // System.out.println(" no skip");
            idx = check;
            answer.add(tmp);
            tmp = 1;
        }
        answer.add(tmp);
        return answer.stream().mapToInt(i->i).toArray();
    }
}