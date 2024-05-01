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
            if (top == -1) {
                stack[++top] = ch;
            } else {
                while (top != -1 && remove != 0 && stack[top] < ch) {
                    remove--;
                    top--;
                }
                stack[++top] = ch;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(remove != 0) top -= remove;
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
        }
        System.out.println(sb);
    }
}