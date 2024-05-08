import java.util.*;
import java.io.*;

class Solution {
    private static final int MOD = 20171109;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            PriorityQueue<Integer> right = new PriorityQueue<>();
            PriorityQueue<Integer> left = new PriorityQueue<>((i1, i2) -> i2 - i1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            right.add(Integer.parseInt(st.nextToken()));
            
            int answer = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                if (num1 > num2) {
                    right.add(num1);
                    left.add(num2);
                } else {
                    right.add(num2);
                    left.add(num1);
                }

                while (right.peek() < left.peek()) {
                    int minVal = right.poll();
                    int maxVal = left.poll();
                    right.add(maxVal);
                    left.add(minVal);
                }

                answer = (right.peek() + answer) % MOD;
            }
            sb.append(String.format("#%d %d\n",tc,answer));
        }
        System.out.println(sb);
    }
}