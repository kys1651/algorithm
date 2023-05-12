import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= N; i ++){
            q.add(i);
        }

        sb.append("<");
        int count = 1;
        while (!q.isEmpty()) {
            if(count == K){
                sb.append(q.pop());
                if(q.size() != 0) sb.append(", ");
                else sb.append(">");
                count = 1;
                continue;
            }

            q.add(q.poll());
            count++;
        }
        System.out.println(sb.toString());
    }
}
