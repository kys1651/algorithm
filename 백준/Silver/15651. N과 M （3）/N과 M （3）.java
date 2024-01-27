import java.util.*;
import java.io.*;

public class Main {
    /** 메모리를 아끼기 위해서 StringBuilder */
    static StringBuilder sb = new StringBuilder();
    /** N개 숫자중 M개를 뽑아서 저장하는 배열 */
    static int[] answer;
    /** 입력값 N과 M */
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // m개의 숫자를 뽑는 것이니까 m개로 선언
        answer = new int[m];

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

        // 1부터 n까지 중복이 없는 것이기 때문에 값을 저장 후 재귀호출을 한다.
        for (int i = 1; i <= n; i++) {
            answer[depth] = i;
            combination(depth + 1);
        }
    }
}