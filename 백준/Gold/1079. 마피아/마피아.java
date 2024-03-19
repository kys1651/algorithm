import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] people;
    static boolean[] isDead;
    static int[][] value;
    static int mafia, result, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isDead = new boolean[N];
        people = new int[N];

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }// Input End

        value = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                value[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        mafia = Integer.parseInt(br.readLine());

        solve(0, N);

        System.out.println(result);
    }

    private static void solve(int day, int peopleCount) {
        // 본인을 제외하고 더이상 죽일 시민이 없는 경우 -> 최적의 해
        if (peopleCount == 1) {
            System.out.println(day);
            System.exit(0);
        }
        if (day > result) {
            result = day;
        }

        // 짝수일 경우 마피아가 죽임(밤)
        if (peopleCount % 2 == 0) {
            // 원본 저장
            int[] origin = new int[N];
            for (int i = 0; i < N; i++) {
                origin[i] = people[i];
            }
            for (int i = 0; i < N; i++) {
                // 이미 죽었거나 마피아 본인인 경우는 죽이지 않는다.
                if (isDead[i] || i == mafia) {
                    continue;
                }
                // 찾아서 죽여줌
                isDead[i] = true;
                for (int j = 0; j < N; j++) {
                    if (isDead[j]) continue;
                    people[j] += value[i][j];
                }
                solve(day + 1, peopleCount - 1);
                // 상태 원본으로 복구
                for (int j = 0; j < N; j++) {
                    if(isDead[j]) continue;
                    people[j] = origin[j];
                }
                isDead[i] = false;
            }
        }
        // 홀수인 경우
        else {
            int kill = getKill();
            // 죽어야 할 사람이 마피아거나 없는 경우 종료
            if (kill == mafia || kill == -1) {
                return;
            }
            // 유죄 지수가 가장 높은 사람을 죽임
            isDead[kill] = true;
            solve(day, peopleCount - 1);
            // 상태 복구
            isDead[kill] = false;
        }
    }

    private static int getKill() {
        int maxIdx = -1;
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            if (isDead[i]) {
                continue;
            }
            if (maxValue < people[i]) {
                maxIdx = i;
                maxValue = people[i];
            }
        }
        return maxIdx;
    }
}  