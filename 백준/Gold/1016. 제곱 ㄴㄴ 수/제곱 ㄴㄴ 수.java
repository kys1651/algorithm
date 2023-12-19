import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 최소값과 최대값을 입력받아 범위만큼의 배열 생성
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] visit = new boolean[(int) (max - min + 1)];

        // 2부터 2의 제곱이 max보다 작거나 같을 때 까지 진행해줌(제곱수가 max보다 크다면 처리 곤란)
        for(long i = 2; i * i <= max; i++){
            long pow = i * i;

            // 시작 지점은 min보다 크거나 같아야하기 때문에 나누어 떨어진다면 몫부터 아니라면 몫+1부터 시작
            long start = min % pow == 0 ? (min / pow) : (min / pow) + 1;

            // 제곱수의 배수들을 전부 제거해줌
            for (long j = start; j * pow<= max; j++) {
                // j는 min <= j <= max 실제 범위를 다루기 때문에 min을 빼주어 배열에 사용할 수 있도록 함
                int idx = (int) (j * pow - min);
                if(!visit[idx]){
                    visit[idx] = true;
                }
            }
        }

        int count = 0;
        for (boolean v : visit) {
            if(!v) count++;
        }
        System.out.println(count);
    }
}
