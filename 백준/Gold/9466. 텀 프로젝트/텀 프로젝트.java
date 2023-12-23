import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit, finish;
    static int[] students;
    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            n = Integer.parseInt(br.readLine());
            answer = 0;

            // 싸이클이 생성된 결과를 저장하는 result 배열
            visit = new boolean[n + 1];
            // 방문한 경로를 저장하는 visit 배열
            finish = new boolean[n + 1];
            // 학생들이 선택한 학생을 저장하는 students 배열
            students = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }
            // 자기 자신을 가르키는 학생을 먼저 처리해준다.
            for (int i = 1; i <= n; i++) {
                if (i == students[i]) {
                    // 처리 완료
                    finish[i] = visit[i] = true;
                    // 구성원에 있으므로 더해준다.
                    answer++;
                }
            }

            for (int i = 1; i <= n; i++) {
                // 방문한 적 있는 학생이라면 굳이 dfs 할 필요 없다.
                if (!visit[i]) {
                    dfs(i);
                }
            }
            sb.append(n - answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        visit[cur] = true;
        int select = students[cur];
        if (!visit[select]) {
            dfs(select);
        } else {
            if (!finish[select]) {
                answer++;
                for (int s = select; s != cur; s = students[s]) {
                    answer++;
                }
            }
        }

        finish[cur] = true;
    }
}
