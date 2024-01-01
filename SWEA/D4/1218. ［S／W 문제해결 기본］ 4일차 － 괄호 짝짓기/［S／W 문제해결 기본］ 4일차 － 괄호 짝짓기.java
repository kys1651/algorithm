import java.util.Stack;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Solution {
    static char[] front = {'(','[','{','<'};
    static char[] rear = {')',']','}','>'};
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();
            sb.append("#" + tc + " " + (validText(len,line) ? "1" : "0")).append("\n");
		}
        System.out.println(sb);
	}
    private static boolean validText(int len, String text){
        Stack<Character> stack = new Stack<>();
        boolean isFront;
        for(int i = 0 ; i < len; i++){
            char ch = text.charAt(i);
            isFront = true;
            
            // 뒤 괄호인 경우 기존 스택의 앞에 있는지 확인한다.
            for(int j = 0; j < 4; j++){
                // 뒤에 있는 괄호를 발견한 경우
                if(ch == rear[j]){
                    // 스택이 비어있거나 stack의 탑이 현재 앞 괄호와 다른 경우 숏컷으로 종료
                    if(stack.isEmpty() || stack.peek() != front[j]){
                        return false;
                    }
                    // 동일한 경우 빼준 뒤 Front가 아니라고 체크
                    else{
                        stack.pop();
                        isFront = false;
                    }
                    break;
                }
            }
            
            // ch가 앞괄호라면 push해줌
            if(isFront){
                stack.push(ch);
            }
        }
        // 모든 연산이 끝난 후 Stack가 비어있어야 올바른 경우
        return stack.isEmpty();
    }
}