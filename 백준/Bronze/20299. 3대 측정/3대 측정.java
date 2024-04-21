import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> pq = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if(arr[j] < L) {
                    sum = -1;
                    break;
                };
                sum += arr[j];
            }
            if (sum >= K) {
                count++;
                pq.add(arr[0]);
                pq.add(arr[1]);
                pq.add(arr[2]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        while(!pq.isEmpty()) sb.append(pq.poll()).append(' ');
        System.out.println(sb);
    }
}
