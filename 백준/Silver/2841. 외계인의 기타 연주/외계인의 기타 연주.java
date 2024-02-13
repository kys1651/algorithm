import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, P, result;
    static Stack<Integer>[] stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        stack = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            stack[i] = new Stack<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int nextNum = Integer.parseInt(st.nextToken());
            int nextPlat = Integer.parseInt(st.nextToken());

            isPop(nextNum, nextPlat);
        }

        System.out.println(result);
    }

    private static void isPop(int nextNum, int nextPlat) {
        while (!stack[nextNum].isEmpty() && stack[nextNum].peek() > nextPlat) {
            result++;
            stack[nextNum].pop();
        }
        if (stack[nextNum].isEmpty() || stack[nextNum].peek() != nextPlat) {
            stack[nextNum].push(nextPlat);
            result++;
        }
    }
}