import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] belt = new int[2 * N];
        boolean[] robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0,answer = 0;
        while (count < K) {
            answer++;
            // 1. 벨트 회전 및 로봇 회전
            int tmp = belt[belt.length - 1];
            for (int i = belt.length - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = tmp;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            // 마지막과 첫번째는 존재하지 않음
            robot[0] = robot[N - 1] = false;

            // 2. 로봇 회전 체크
            for (int i = N - 1; i > 0; i--) {
                if(!robot[i] && robot[i-1] && belt[i] > 0){
                    robot[i] = true;
                    robot[i-1] = false;
                    belt[i]--;
                    if(belt[i] <= 0) count++;
                }
            }

            // 3. 올리는 위치 확인
            if(belt[0] > 0){
                robot[0] = true;
                belt[0]--;
                if(belt[0] <= 0) count++;
            }
        }

        System.out.println(answer);
    }
}

