import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] check;
    static int N, M;
    static int min;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        check = new boolean[10]; // 0 ~ 9까지 숫자 버튼

        if(M != 0) { // 고장난 버튼이 있을 때
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (M-- > 0) {
                // 고장난 버튼의 인덱스를 0으로 교채해줌
                check[Integer.parseInt(st.nextToken())] = true;
            }
        }

        solution();

        System.out.println(min);
    }

    private static void solution() {
        // 목표 위치에서 100을 뺀  +, -로만 간 횟수로 초기화
        min = Math.abs(N - 100);

        // 최대값은 500,000이므로 6자리 최대값인 999,999까지 돌려줌
        for (int i = 0; i < 999999; i++) {
            String str = String.valueOf(i);
            boolean flag = false;

            for(int j = 0 ; j < str.length(); j++){
                if(check[str.charAt(j)-'0']) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                min = Math.min(str.length() + Math.abs(N - i), min);
            }
        }
    }
}
