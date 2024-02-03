import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 30) {
            sb.append((1 << n) - 1).append("\n");
        }else{
            sb.append(new BigInteger("1").shiftLeft(n).subtract(new BigInteger("1"))).append("\n");
        }

        if (n <= 20) {
            hanoi(n, 1, 3);
        }
        
        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int to) {
        if(n == 1){
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, from, 6 - from - to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, 6 - from - to, to);
    }
}
