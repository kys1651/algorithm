import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());


        Deque<Integer> queue = new LinkedList<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
            }else if(command.equals("pop")){
                if(queue.isEmpty()){
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(queue.poll()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                if(queue.isEmpty())
                    sb.append("1").append("\n");
                else
                    sb.append("0").append("\n");
            } else if(command.equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(queue.peekFirst()).append("\n");
            } else if (command.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(queue.peekLast()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
