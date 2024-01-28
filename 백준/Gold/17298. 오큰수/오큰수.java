import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 현재 위치보다 작은 인덱스에 전부 삽입해줌
            while (!stack.isEmpty() && num[stack.peek()] < num[i]) {
                num[stack.pop()] = num[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            num[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(num[i]).append(" ");
        }
        System.out.println(sb);
    }
}