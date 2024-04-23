import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());

            // Input
            LinkedList<String> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(st.nextToken());
            }// Input End

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x,y;
            for (int i = 0; i < M; i++) {
                String command = st.nextToken();
                x = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        list.add(x + j, st.nextToken());
                    }
                } else if (command.equals("D")) {
                    y = Integer.parseInt(st.nextToken());
                    while (y-- > 0) {
                        list.remove(x);
                    }
                } else {
                    for (int j = 0; j < x; j++) {
                        list.addLast(st.nextToken());
                    }
                }
            }

            sb.append('#').append(tc).append(' ');
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
