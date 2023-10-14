import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());;
        }

        /**
         * 스택이 비어있지 않으면서
         * 현재 원소가 스택의 Top 원소보다 큰 경우
         * 해당 조건을 만족할 때 까지 stack에서 pop
         * 해당 인덱스의 값을 현재원소로 교체함
         * 
         * 쉽게 표현하면 스택에 들어있는 인덱스의 value를 가장 크면 바로 교체해주는 것임
         */
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        for (int n : arr) {
            bw.write(n + " ");
        }
        bw.flush();
        bw.close();
    }
}
