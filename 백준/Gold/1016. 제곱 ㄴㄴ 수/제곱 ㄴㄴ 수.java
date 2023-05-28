import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        // 최소값과 최대값 입력 받은 후 그 범위를 length에 해당함 +1을 한 이유는 최소값도 포함하기 위해서
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int length = (int) (max - min + 1);

        // 제곱 ㄴㄴ수인지 아닌지를 확인하기 위한 배열 생성
        boolean[] nonSquare = new boolean[length];

        // 소수는 2부터 시작하므로 생성하고 i * i이 max보다 적거나 같아야 범위에 들어옴
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i; // 소수의 제곱

            long start = min / pow; // 최소값의 범위부터 시작하기 위해서 몫을 start로 함
            if (min % pow != 0) {
                // 만약 나머지가 0이 아니라면 +1을 해주어 범위 내에서 시작 할 수 있도록 함
                start++;
            }

            // 시작부터하여 제곱의 배수를 전부 true로 바꾸어줌
            // index에서 min을 한 이유는 배열이 min~max의 범위만큼이기 때문에
            for (long j = start; j * pow <= max; j++) {
                int index = (int)(j * pow - min);
                nonSquare[index] = true;
            }
        }

        int count = 0;
        // 배열에서 true가 아닌 수(제곱 ㄴㄴ수)의 수를 카운트
        for (boolean check : nonSquare) {
            if(!check) count++;
        }

        System.out.println(count);
    }
}
