import java.util.*;
import java.io.*;


/*
	작성자 : 김용수
	문제 : [백준] 15657번 : N과 M(8) Silve3(실버3)
	제출 : 2024년 1월 27일 19:42:53
	결과 : 맞았습니다!!
	성능 요약 : 메모리:17192KB 시간:116ms

	접근 방법
	1. 숫자 N개 중 M개를 중복 허용하여 뽑는 것이다.
    2. 비내림차순으로 출력하기 위해서 파라미터를 추가한다.
*/
public class Main {
    // 메모리를 아끼기 위해서 StringBuilder
    static StringBuilder sb = new StringBuilder();
    // M개를 뽑아서 저장하는 answer, N개의 숫자를 저장하는 num
    static int[] answer, num;
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

        // 입력 받은 뒤 정렬
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        combination(0,0);

        System.out.println(sb);
    }

    // 조합을 뽑는 메서드 dfs를 기반으로 로직을 처리
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

        // 1부터 n까지 중복 가능한 비내림차순. 오름차순된 배열이기 때문에 at부터 삽입 후 i로 dfs
        for (int i = at; i < n; i++) {
            answer[depth] = num[i];
            combination(depth + 1, i);
        }
    }
}