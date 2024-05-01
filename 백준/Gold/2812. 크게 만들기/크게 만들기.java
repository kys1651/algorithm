import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = br.readLine();

        char[] stack = new char[N];
        int remove = K;
        int top = -1;
        for (char ch : input.toCharArray()) {
            if (top != -1) {
                while (top != -1 && remove != 0 && stack[top] < ch) {
                    remove--;
                    top--;
                }
            }
            stack[++top] = ch;
        }
        if (remove != 0) top -= remove;

        System.out.println(new String(stack, 0, top + 1));
    }
}