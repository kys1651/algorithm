import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] next = new int[1000001];
        int[] prev = new int[1000001];
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        num[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            next[num[i - 1]] = num[i];
            prev[num[i]] = num[i - 1];
        }
        prev[num[0]] = num[N - 1];
        next[num[N - 1]] = num[0];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String Command = st.nextToken(); // 명령어
            int idx = Integer.parseInt(st.nextToken()); // 기준 인덱스

            if (Command.equals("BN")) {
                int tmp = Integer.parseInt(st.nextToken());

                // 다음 인덱스 값 찾아오기
                int nextIdx = next[idx];

                // 새로운 지하철 생성
                next[tmp] = nextIdx;
                prev[tmp] = idx;

                // 새로운 지하철 연결
                next[idx] = tmp;
                prev[nextIdx] = tmp;

                sb.append(nextIdx);
            } else if (Command.equals("BP")) {
                int tmp = Integer.parseInt(st.nextToken());

                // 이전 인덱스 값 찾아오기
                int prevIdx = prev[idx];

                // 새로운 지하철 생성
                next[tmp] = idx;
                prev[tmp] = prevIdx;

                // 새로운 지하철 연결
                prev[idx] = tmp;
                next[prevIdx] = tmp;

                sb.append(prevIdx);
            } else if (Command.equals("CN")) {
                // 다음 노드의 인덱스
                int nextIdx = next[idx];
                next[idx] = next[nextIdx];
                prev[next[nextIdx]] = idx;

                // 연결 끊기
                next[nextIdx] = prev[nextIdx] = 0;

                sb.append(nextIdx);
            } else {
                // 이전 노드의 인덱스
                int prevIdx = prev[idx];
                prev[idx] = prev[prevIdx];
                next[prev[prevIdx]] = idx;

                // 연결 제거
                next[prevIdx] = prev[prevIdx] = 0;

                sb.append(prevIdx);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}

