import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long answer = 0;
        long plus = 1;
        long num = 10;
        for (long i = 1; i <= N; i++) {
            if (i % num == 0) {
                plus++;
                num *= 10;
            }
            answer += plus;
        }

        System.out.println(answer);
        //100000000
    }
}


