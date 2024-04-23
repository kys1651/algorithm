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
            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }// Input End

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                String command = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    for (int j = 0; j < y; j++) {
                        int s = Integer.parseInt(st.nextToken());
                        list.add(x + j, s);
                    }
                } else if (command.equals("D")) {
                    while (y-- > 0) {
                        list.remove(x);
                    }
                } else {
                    list.addLast(y);
                    for (int j = 1; j < x; j++) {
                        y = Integer.parseInt(st.nextToken());
                        list.addLast(y);
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
