import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static boolean prime[] = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n;

        getPrime();

        while ((n = Integer.parseInt(br.readLine())) != 0) {

            boolean flag = false;

            for (int i = 2; i <= n / 2; i++) {
                if (!prime[i] && !prime[n - i]) {
                    sb.append(n + " = " + i + " + " + (n - i)).append("\n");
                    flag = true;
                    break;
                }
            }

            if(!flag){
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void getPrime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;

            for (int j = i * 2; j < prime.length; j+= i) {
                prime[j] = true;
            }
        }
    }
}