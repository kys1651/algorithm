import java.util.*;
import java.io.*;

public class Main {
    // 메모리를 아끼기 위해서 StringBuilder
    static StringBuilder sb = new StringBuilder();
    // M개를 뽑아서 저장하는 answer, N개의 숫자를 저장하는 num
    static int[] answer, num;
    // 중복 방문을 처리하는 boolean 배열
    static boolean[] visit;
    /**
     * 입력값 N과 M
     */
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // m개의 숫자를 뽑는 것이니까 m개로 선언
        answer = new int[m];
        num = new int[n];
        visit = new boolean[n];

        // 입력 받은 뒤 정렬
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        combination(0);

        System.out.println(sb);
    }

    // 조합을 뽑는 메서드 dfs를 기반으로 로직을 처리
    private static void combination(int depth) {
        // 현재 뽑아온 숫자가 m개면 값을 저장한다.
        if (depth == m) {
            // 배열에 있는 숫자를 전부 저장
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 n까지 중복이 없고 오름차순. 방문한 곳은 넘어간다.
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            answer[depth] = num[i];
            combination(depth + 1);
            visit[i] = false;
        }
    }
}