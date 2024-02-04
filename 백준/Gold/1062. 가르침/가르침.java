import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, bit, result;
    static int[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 필수로 배워야하는 단어들의 위치를 켜준다.
        String alphabet = "antic";
        for (char ch : alphabet.toCharArray()) {
            bit = bit | (1 << ch - 'a');
        }


        words = new int[N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            // input값이 필요한 알파벳을 켜준다. bit는 기본으로 가지고 있어야 함.
            int inputBit = bit;
            for (int j = 4; j < input.length() - 4; j++) {
                inputBit = inputBit | (1 << input.charAt(j) - 'a');
            }
            // words에 넣어준다.
            words[i] = inputBit;
        }

        // K가 5개 이하면 배울 수 없음
        if (K < 5) {
            System.out.println(0);
            return;
        }
        // K가 26이라면 모든 알파벳을 배울 수 있음
        else if (K == 26) {
            System.out.println(N);
            return;
        }

        // 5개를 제외한 나머지만 계산 하면 된다.
        K -= 5;

        combination(0, 0);

        System.out.println(result);
    }

    private static void combination(int depth, int at) {
        if (depth == K) {
            int count = N;
            for (int word : words) {
                if ((bit | word) != bit) {
                    // 만약 모르는 단어가 있다면 카운트를 감소.
                    count--;
                    // 최대 단어 개수보다 적어진다면 더 이상 체크 필요 X
                    if (result > count) {
                        return;
                    }
                }
            }
            result = count;
            if (result == N) {
                System.out.println(N);
                System.exit(0);
            }
            return;
        }

        // a ~ z 는 0 ~ 25이다.
        for (int i = at; i < 26; i++) {
            // 알고 있다면 넘어간다.
            if ((bit & (1 << i)) != 0) {
                continue;
            }

            // 모르고 있었다면 비트를 켜줌
            bit = bit | (1 << i);
            combination(depth + 1, i + 1);
            // 다시 꺼준다.
            bit = bit & ~(1 << i);

        }
    }

}
