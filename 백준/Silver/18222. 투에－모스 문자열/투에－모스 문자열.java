import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long right = 1;
        for (; right < N; right *= 2) {}

        boolean reverse = false;
        long left = 1;
        while (N != 1) {
            long mid = (right + left) / 2;
            if (N > mid) {
                reverse = !reverse;
                N -= mid;
            }
            right = mid;
        }

        System.out.println(reverse ? 1 : 0);
    }
}

