import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] food = new int[N];
        for (int i = 0; i < N; i++) {
            food[i] = Integer.parseInt(br.readLine());
        }

        int[] dish = new int[D + 1];
        int left = 0, right = 0, count = 1, quantity = 1, answer = 0;
        dish[food[left]] = 1;
        while (left < N) {
            right = (right + 1) % (N);

            count++;
            dish[food[right]]++;
            if (dish[food[right]] == 1) {
                quantity++;
            }
            answer = Math.max(answer, quantity);

            if (count == K) {
                if (dish[C] == 0) {
                    answer = Math.max(answer, quantity + 1);
                }
                count--;
                dish[food[left]]--;
                if (dish[food[left]] == 0) {
                    quantity--;
                }
                left++;
            }

            if (answer == K + 1) {
                System.out.println(K + 1);
                return;
            }
        }
        System.out.println(answer);
    }
}