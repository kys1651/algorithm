import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static boolean prime[] = new boolean[2000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        getPrime();

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long sum = a + b;

            if(sum < 4){
                sb.append("NO").append('\n');
            } else if (sum % 2 == 0) {
                sb.append("YES").append('\n');
            } else {
                // 홀수가 되기위해서는 짝수 + 홀수가 되어야만 함
                // 짝수인 소수는 2밖에 없으므로 sum에서 2를 뺀 뒤 소수인지 확인
                if (check(sum - 2)) {
                    // 소수일 때
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }
        }

        System.out.println(sb);
    }

    private static boolean check(long num) {
        if (num <= 2000000) { // 4 * 10^ 12의 루트인 2000000보다 작은 경우
            return !prime[(int) num];
        }

        // 큰 경우
        for (int i = 0; i < list.size(); i++) {
            // 소수로 나누어진다면 그것은 소수가 아님
            if (num % list.get(i) == 0) {
                return false;
            }
        }

        return true;
    }

    private static void getPrime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i < prime.length; i++) {
            if(prime[i]) continue;

            list.add(i);
            for (int j = i * 2; j < prime.length; j+= i) {
                prime[j] = true;
            }
        }
    }


}
