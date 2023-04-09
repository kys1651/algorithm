import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> q;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {

            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            q = new ArrayDeque<Integer>();

            // 덱에 배열 원소를 넣어준다.
            for(int i = 0; i < n; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            AC(command, q);
        }

        System.out.println(sb);

    }

    public static void AC(String command, ArrayDeque<Integer> deque) {

        boolean Right = true;

        for(char cmd : command.toCharArray()) {

            if(cmd == 'R') {
                Right = !Right;
                continue;
            }

            if(Right) {

                if(deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }

            }
            else {
                if(deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        // 모든 함수들이 정상적으로 작동했다면 덱의 남은 요소들을 출력문으로 만들어준다.
        makePrintString(deque, Right);

    }

    public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {

        sb.append('[');
        if(deque.size() > 0) {
            if(isRight) {
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else {
                sb.append(deque.pollLast());

                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');	// 닫는 대괄호 및 개행으로 마무리
    }
}