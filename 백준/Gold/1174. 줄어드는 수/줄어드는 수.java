import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N > 1023){
            System.out.println(-1);
            return;
        }
        
        for (int i = 1; i <= 10; i++) {
            combination(0, 10, 0, i);
        }
        System.out.println(-1);
    }

    private static void combination(int depth, int end, long value, int limit) {
        if (depth == limit) {
            N--;
            if (N == 0) {
                System.out.println(value);
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < end; i++) {
            combination(depth + 1, i, value * 10 + i, limit);
        }
    }
}
