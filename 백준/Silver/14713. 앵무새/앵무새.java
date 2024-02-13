import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Queue<String>[] queues = new Queue[N];
        for (int i = 0; i < N; i++) {
            queues[i] = new LinkedList<>();
            String input = br.readLine();
            for (String s : input.split(" ")) {
                queues[i].add(s);
            }
        }

        String text = br.readLine();
        for (String word : text.split(" ")) {
            boolean result = false;
            for (int i = 0; i < N; i++) {
                if(queues[i].isEmpty()) continue;
                if (queues[i].peek().equals(word)) {
                    result = true;
                    queues[i].poll();
                    break;
                }
            }
            if(!result){
                System.out.println("Impossible");
                System.exit(0);
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (!queues[i].isEmpty()) {
                System.out.println("Impossible");
                System.exit(0);
            }
        }
        System.out.println("Possible");
    }
}