import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static boolean[] button = new boolean[10];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                // true는 사용하지 못하는 버튼
                button[Integer.parseInt(st.nextToken())] = true;
            }
        }

        combination();
    }

    private static void combination() {
        int min = Math.abs(N - 100);

        for (int i = 0; i < 999_999; i++) {
            String num = String.valueOf(i);
            boolean flag = true;

            for (int j = 0; j < num.length(); j++) {
                if (button[num.charAt(j) - '0']) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                min = Math.min(num.length() + Math.abs(N - i), min);
            }
        }
        
        System.out.println(min);
    }
}