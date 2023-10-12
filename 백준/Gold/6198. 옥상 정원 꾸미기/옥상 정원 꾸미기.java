import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 내림차순 정렬된 스택
        Stack<Integer> stack = new Stack<>();

        long result = 0;
        for (int i = 0; i < n; i++) {
            int building = Integer.parseInt(br.readLine());

            // 스택이 비지 않을 동안 실행
            while (!stack.isEmpty()) {

                // 스택의 Top값이 현재 입력 받은 값보다 작다면 pop해줌
                if (stack.peek() <= building) {
                    stack.pop();
                } else {
                    // 더 이상 크지 않다면 break;
                    break;
                }
            }
            // 스택 사이즈를 더해주면서 가능한 개수를 더해준다.
            result += stack.size();
            // 입력 받은 빌딩의 높이를 넣어준다.
            stack.push(building);
        }

        System.out.println(result);
    }
}
