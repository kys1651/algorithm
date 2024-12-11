import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(String operation : operations){
            String[] oper = operation.split(" ");
            int val = Integer.parseInt(oper[1]);
            if(oper[0].equals("D")){
                if(ts.isEmpty()) continue;
                else if(val == 1) ts.pollLast();
                else ts.pollFirst();
            } else {
                ts.add(val);
            }
        }
        int[] answer = new int[2];
        if(!ts.isEmpty()){
            answer[0] = ts.pollLast();    
            if(ts.isEmpty()) answer[1] = answer[0];
            else answer[1] = ts.pollFirst();
        }
        return answer;
    }
}