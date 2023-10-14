import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long count = 0;

        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            Pair pair = new Pair(tmp, 1);

            while (!stack.isEmpty() && stack.peek().height <= tmp) {
                Pair top = stack.pop();
                count += top.count;
                if (top.height == tmp) {
                    pair.count += top.count;
                }
            }

            if (!stack.empty()) {
                count++;
            }

            stack.push(pair);
        }
        System.out.println(count);
    }

    static class Pair {
        int height;
        int count;

        Pair(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
}
