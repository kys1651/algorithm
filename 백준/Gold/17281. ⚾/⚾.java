import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    // 각 이닝당 선수들이 얻는 결과
    static int[][] scores;
    // 순열
    static int[] permutation = new int[9];
    static boolean[] visit = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 4번선수[3]는 무조건 0번[1]타자
        permutation[3] = 0;
        visit[0] = true;

        // 순열을 얻는다.
        getPermutation(0);

        System.out.println(result);
    }

    private static void getPermutation(int depth) {
        // 9명의 순열을 구했다면 게임 진행
        if (depth == 9) {
            playGame();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            permutation[depth] = i;

            // 4번째타자[3]는 구할 필요 없음
            if(depth == 2){
                getPermutation(depth + 2);
            }else{
                getPermutation(depth + 1);
            }
            visit[i] = false;
        }
    }

    // 게임 진행
    private static void playGame() {
        int gameScore = 0; // 게임 스코어
        int base1; // 현재 1루
        int base2; // 현재 2루
        int base3; // 현재 3루
        int idx = 0; // 타자 순서

        for (int i = 0; i < N; i++) {
            int outCount = 0; // 아웃 카운트
            base1 = base2 = base3 = 0; // 초기화

            while (outCount != 3) {
                // 현재 주자가 얻을 수 있는 결과
                int getScore = scores[i][permutation[idx]];

                // 아웃인 경우
                if (getScore == 0) {
                    outCount++;
                }
                // 안타인 경우 -> 각 주자 1루씩 진출
                else if (getScore == 1) {
                    gameScore += base3;
                    base3 = base2;
                    base2 = base1;
                    base1 = 1;
                } else if (getScore == 2) {
                    gameScore += base3 + base2;
                    base3 = base1;
                    base1 = 0;
                    base2 = 1;
                } else if (getScore == 3) {
                    gameScore += base1 + base2 + base3;
                    base1 = base2 = 0;
                    base3 = 1;
                } else if (getScore == 4) {
                    gameScore += base1 + base2 + base3 + 1;
                    base1 = base2 = base3 = 0;
                }
                idx = (idx + 1) % 9;
            }
        }

        if (result < gameScore) result = gameScore;
    }
}