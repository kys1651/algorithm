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
    // M개를 뽑아서 저장하는 answer
    static int[] answer,num;
    // 방문처리를 하는 visit
    static boolean[] visit;
    // 입력값 N과 M
    static int n, m;
    // 정답을 저장하는 List
    static ArrayList<String> result = new ArrayList<>();

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
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    // 조합을 뽑는 메서드 dfs를 기반으로 로직을 처리
    private static void combination(int depth) {
        // 현재 뽑아온 숫자가 m개면 값을 저장한다.
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            // 배열에 있는 숫자를 전부 저장 후 hashSet에 넣어줌(중복되는 수열 제거)
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            if(!result.contains(sb.toString())){
                result.add(sb.toString());
            }
            return;
        }

        // 1부터 n까지 중복 가능한 비내림차순. 오름차순된 배열이기 때문에 at부터 삽입 후 i로 dfs
        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            answer[depth] = num[i];
            combination(depth + 1);
            visit[i] = false;
        }
    }
}