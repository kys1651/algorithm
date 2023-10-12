import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    // 탑의 번호
    int idx;
    // 탑의 높이
    int height;

    Top(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}


public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            // stack이 비어있다면 앞에 탑은 현재 탑보다 큰 것이 없으므로 0을 추가한다.
            // 그 후 스택에 탑을 넣어줌
            if (stack.isEmpty()) {
                answer.append("0 ");
                stack.push(new Top(i, height));
            } else {
                // 스택이 비어있지 않다면 while문을 실행
                while (true) {
                    // 스택이 비어있을 때 까지 while문을 돌린다면 현재 탑보다 더 큰 탑은 없던 것임
                    // 위와 같은 operation을 취함
                    if (stack.isEmpty()) {
                        answer.append("0 ");
                        stack.push(new Top(i, height));
                        break;
                    }
                    // 현재 위치에서 가장 가까운 탑을 꺼내줌
                    Top top = stack.peek();

                    // 가장 가까운 Top의 높이가 현재 위치보다 크다면 answer에 추가해준다.
                    if (top.height > height) {
                        answer.append(top.idx + " ");
                        stack.push(new Top(i, height));
                        break;
                    } else {
                        // 가장 가까운 Top의 높이가 현재 위치보다 크다면 스택에 있는 탑은 제거해도 된다.
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(answer.toString());
    }
}
