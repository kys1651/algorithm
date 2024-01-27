import java.util.*;
import java.io.*;

/*
	작성자 : 김용수
	문제 : [백준] 15663번 : N과 M(9) Silve2(실버2)
	제출 :
	결과 :
	성능 요약 :

	접근 방법
	1. 숫자 N개 중 M개를 중복 허용없이 뽑는 것이다.
    2. 중복되는 수열을 여러번 출력하면 안되기 때문에 List에 결과를 삽입한다.
*/
public class Main {
    // 메모리 절약을 위한 StringBuilder
    static StringBuilder sb = new StringBuilder();
    // M개를 뽑아서 저장하는 answer
    static int[] answer, num;
    // 방문처리를 하는 visit
    static boolean[] visit;
    // 입력값 N과 M
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

        // 1부터 n까지 중복 되는 수열을 여러 번 출력하면 안된다.
        // 중복 되는 수열이 여러번 호출되는 과정 -> 같은 숫자가 두번 반복 호출됨.
        // -> 이전에 호출한 값이 현재 호출값보다 같다면 호출하지 않으면 된다.
        int prev = 0;
        for (int i = 0; i < n; i++) {
            // 방문했거나 이전에 호출한 적 있다면 넘어감
            if (visit[i] || prev == num[i]) continue;

            visit[i] = true;
            answer[depth] = prev = num[i];
            combination(depth + 1);
            visit[i] = false;
        }
    }
}