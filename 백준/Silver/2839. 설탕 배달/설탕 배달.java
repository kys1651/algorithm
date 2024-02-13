import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (true) {
            if (n % 5 == 0) {
                count += n / 5;
                break;
            }
            n -= 3;
            count++;
            if (n < 0) {
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}