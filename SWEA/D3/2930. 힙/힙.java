import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            sb.append('#').append(tc).append(' ');
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                if (input[0].equals("1")) {
                    pq.add(Integer.parseInt(input[1]));
                }else{
                    if(pq.isEmpty()) sb.append("-1");
                    else sb.append(pq.poll());
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}