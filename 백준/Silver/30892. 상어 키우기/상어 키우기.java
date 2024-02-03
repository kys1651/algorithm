import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 상어의 마릿수
        int K = Integer.parseInt(st.nextToken()); // 먹을 수 있는 상어의 최대 마릿수
        long T = Integer.parseInt(st.nextToken()); // 최초 크기

        // 상어의 배열
        int[] sharks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sharks[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬을 해준다.
        Arrays.sort(sharks);

        Stack<Integer> stack = new Stack<>();
        int count = 0; // 현재 샼이 먹은 상어의 개수
        for (int shark : sharks) {
            // 스택이 비지않고 && 샼이 현재 바라보는 상어보다 작거나 같고 && K만큼 먹지 않았을 때
            while (!stack.isEmpty() && shark >= T && count < K) {
                // 먹을 수 있는 가장 큰 상어를 먹어준 뒤 먹은 개수를 늘려준다.
                T += stack.pop();
                count++;
            }
            // 만약 K만큼 먹었거나 || 값을 처리했는데도 바라보는 상어보다 작거나 같다면 종료
            if (count == K || shark >= T) {
                break;
            }
            // 위 연산 수행 후 shark는 샼보다 작은 상어일 것이다. 스택에 넣어준다.
            stack.add(shark);
        }

        // 위에서 연산을 처리했음에도 count가 남았다면 먹을 수 있는 상어를 다 먹어준다.
        for (int i = 0; i < K - count && !stack.isEmpty(); i++) {
            T += stack.pop();
        }
        // 출력
        System.out.println(T);
    }
}
