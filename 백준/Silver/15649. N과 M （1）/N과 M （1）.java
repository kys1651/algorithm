import java.util.*;
import java.io.*;

public class Main {
    // 총 개수 n과 뽑아야 하는 수 M
    static int m, n;
    // 정답을 담는 answer 배열
    static int[] answer;
    // 방문처리 해주는 visit 배열
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        answer = new int[m];

        solution(0);
        System.out.println(sb);
    }

    private static void solution(int depth) {
        // n개의 숫자 중 m개를 뽑았다면 StringBuilder에 추가
        if (depth == m) {
            for (int i = 0; i < answer.length; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1~n까지 순회한다.
        for (int i = 1; i <= n; i++) {
            // 방문한 배열은 넘어간다.
            if (visit[i]) continue;
            // 방문처리 후 현재 depth에 i 값을 넣고 재귀 호출
            visit[i] = true;
            answer[depth] = i;
            solution(depth + 1);
            visit[i] = false;
        }
    }
}