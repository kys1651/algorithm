import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long T = Integer.parseInt(st.nextToken());

        int[] sharks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sharks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sharks);

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int shark : sharks) {
            while (!stack.isEmpty() && shark >= T && count < K) {
                int tmp = stack.pop();
                T += tmp;
                count++;
            }
            if(count == K){
                break;
            }

            if(shark < T){
                stack.add(shark);
            }else{
                break;
            }
        }
        for (int i = 0; i < K - count && !stack.isEmpty(); i++) {
            T += stack.pop();
        }
        System.out.println(T);
    }
}
