import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int k =Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        int result = 0;
        for(int i = 1; i <= k; i++){
            result = queue.poll();
        }
        System.out.println(result);
    }
}