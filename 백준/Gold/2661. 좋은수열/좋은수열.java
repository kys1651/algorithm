import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs("");
    }

    private static void dfs(String sequence) {
        // 문자열 길이가 n과 같다면 좋은 수열을 이루는 수 중 가장 작은 수임
        if (sequence.length() == n) {
            // 호출 후 종료해줌
            System.out.println(sequence);
            System.exit(0);
        }

        for(int i = 1; i <= 3; i++){
            String nextSequence = sequence + i;
            if (goodSequence(nextSequence)) {
                dfs(nextSequence);
            }
        }
    }

    private static boolean goodSequence(String nextSequence) {
        int len = nextSequence.length();
        for (int i = 1; i <= len / 2; i++) {
            // 인접한 수열의 앞 부분(2길이라면 앞에서 1개, 4길이라면 앞에서 1개,2개
            String front = nextSequence.substring(len - 2 * i, len - i);
            // 인접한 수열의 뒷 부분(2길이라면 뒤에서 1개, 4길이라면 뒤에서 1개, 2개
            String back = nextSequence.substring(len - i);
            // 같다면 나쁜 수열임
            if (front.equals(back)) {
                return false;
            }
        }
        // for문을 빠져나왔다면 좋은 수열이다.
        return true;
    }
}
