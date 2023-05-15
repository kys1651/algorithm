import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[] visited;
    static int N;
    static int answer = Integer.MAX_VALUE;//최소값을 찾기 위해서 미리 넣어줌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        // 값 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0, 0);
        System.out.println(answer);
    }

    // 조합을 짜는 알고리즘
    private static void solution(int idx, int depth) {
        if(depth == N/2){
            // 방문팀과 방문하지 않은 팀을 나누어 계산한다.
            cal();
            return;
        }

        for(int i = idx; i < N; i++){
            // 방문 안했을 때 확인
            if(!visited[i]){
                visited[i] = true;
                solution(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void cal() {
        int team_start = 0;
        int team_link = 0;


        // 전부 더 해주는 식
        for(int i = 0 ; i < N-1; i++){
            for (int j = i+1; j < N; j++) {
                // 둘 다 방문 했을 때(true) 스타트팀이라는 뜻이므로 스타트팀으로 점수 더하기
                if (visited[i] == true && visited[j] == true) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                }


                // 둘 다 방문 안했을 때(false) 링크팀이라는 뜻이므로 링크팀으로 더하기
                if (visited[i] == false && visited[j] == false) {
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }

        // 팀의 점수차이를 계산해줌(절대값)
        int val = Math.abs(team_start - team_link);
        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }

        answer = Math.min(answer, val);
    }
}
