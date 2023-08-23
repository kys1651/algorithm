import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 정답을 저장 할 ArrayList
        ArrayList<Integer> answer = new ArrayList<>();
        // 계산을 위한 stack
        Stack<Integer> stack = new Stack<>();
        
        // 뒤에서부터 해주어 pop하면 첫번째 인덱스부터 계산 할 수 있도록 한다.
        for(int i = speeds.length - 1; i >= 0 ; i --){
            // 100에서 현재 진행률을 빼주어 남은 진행률을 구해준다.
            int progress = 100 - progresses[i];
            int speed = speeds[i];
            int tmp = progress/speed;
            
            // 나머지가 있다면 하루가 더 늘어나야하므로 계산식을 넣어줌
            if(progress%speed > 0){
                tmp ++;
            }
            // 계산 값을 스택에 넣어줌
            stack.push(tmp);
        }
        
        // idx = 지표, count = 현재 배포 할 수 있는 기능
        int idx = stack.pop();
        int count = 1;
        while(!stack.isEmpty()){
            int check = stack.pop();
            
            // 현재 기준보다 작거나 같으면 카운트를 늘려주고 continue;
            if(check <= idx){
                count++;
                continue;
            }
            
            // 더 크다면 idx에 현재 스택에서 pop한 값을 넣어주고 리스트에 count를 추가   
            idx = check;
            answer.add(count);
            count = 1;
        }
        // while문이 끝나고 count값이 남으므로 한번 더 add하여준다.
        answer.add(count);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}