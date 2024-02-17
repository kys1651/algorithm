import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] dist = new long[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        long minCost = Long.parseLong(st.nextToken());
        long distSum = 0;
        long answer = 0;
        for (int i = 0; i < N; i++) {
            long tmp = Long.parseLong(st.nextToken());
            distSum += dist[i];
            if (minCost > tmp) {
                answer += distSum * minCost;
                minCost = tmp;
                distSum = 0;
            }
        }

        if (distSum != 0) {
            answer += distSum * minCost;
        }

        System.out.println(answer);
    }
}

