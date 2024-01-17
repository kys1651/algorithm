import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int five = (n / 5);
        for (int i = five; i >= 0; i--) {
            int money = n - i * 5;
            if (money % 2 == 0) {
                System.out.println(i + money / 2);
                return;
            }
        }
        System.out.println(-1);
    }
}
