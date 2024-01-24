import java.util.*;
import java.io.*;

/*
    작성자 : 김용수
    문제 : [백준] 15650 : N과 M(2) Silver3(실버3)
    제출 :
    결과 :
    성능 요약 :

    접근 방법
    1. 문제는 숫자 N개중 M을 뽑는 것이다.
    2. 오름차순으로 출력해야하기때문에 이전에 방문한 숫자는 방문하지 않는다.
    3. 이전 문제와 다르게 방문처리를 할 필요 없이 파라미터를 하나 추가하여 상태를 가지고 dfs하는 형식으로 진행
    3. 메모리와 시간을 아끼기 위해서 Stringbuilder 사용
*/
public class Main {
    // 총 개수 n과 뽑아야 하는 수 M
    static int m, n;
    // 정답을 담는 answer 배열
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];

        solution(0, 1);
        System.out.println(sb);
    }

    private static void solution(int depth, int at) {
        // n개의 숫자 중 m개를 뽑았다면 StringBuilder에 추가
        if (depth == m) {
            for (int i = 0; i < answer.length; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // at ~ n까지 순회
        for (int i = at; i <= n; i++) {
            // 현재 i값을 넣어준 뒤 depth + 1, 현재 값 + 1을 해준다.
            answer[depth] = i;
            solution(depth + 1, i + 1);
        }
    }
}