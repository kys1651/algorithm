import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // Input
        int sum = 0, max = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> visitCount = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            sum += value;
            queue.add(value);

            if (queue.size() == X) {
                visitCount.put(sum, visitCount.getOrDefault(sum, 0) + 1);
                if (sum > max) max = sum;
                int front = queue.poll();
                sum -= front;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(visitCount.get(max));
        }

    }
}