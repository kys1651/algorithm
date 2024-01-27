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


        combination(0,1);

        System.out.println(sb);
    }

    // 조합을 뽑는 메서드 dfs를 기반으로 로직을 처리
    // 비내림차순을 위해서 상태 파라미터 추가
    private static void combination(int depth,int at) {
        // 현재 뽑아온 숫자가 m개면 값을 저장한다.
        if (depth == m) {
            // 배열에 있는 숫자를 전부 저장
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 n까지 중복이 없고 비 내림차순.
        // 비내림차순이라면 이전 값보다 같거나 커야하기 때문에 at부터 시작한다.
        for (int i = at; i <= n; i++) {
            answer[depth] = i;
            // 현재값보다 같거나 커야하므로 i를 넘겨준다.
            combination(depth + 1, i);
        }
    }
}