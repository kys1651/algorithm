import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 문제 : BJ_2493_탑 골드5
 * @author 김용수
 * 제출한 시간: 2024년 2월 4일 17:39:42
 * 메모리: 105996 KB
 * 시간: 696ms
 *
 * 접근 방법:
 * 1. 현재 탑 위치보다 큰 탑을 기억해줘야한다.
 * 2. 만약 현재 탑 보다 기억한 탑이 더 크다면 더 이상 기억하지 않아도 된다. -> 스택을 활용해주면 쉽게 가능 함
 * 3. 스택에 현재 탑보다 작은 값들을 전부 빼준다.
 * 4. 스택이 비어있다면 0을 넣어주고 더 크다면 그 값을 넣어주면 됨.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek()[1] < height) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append('0');
            }else{
                sb.append(stack.peek()[0]);
            }
            sb.append(' ');
            stack.push(new int[] {i, height});
        }

        System.out.println(sb);
    }
}
