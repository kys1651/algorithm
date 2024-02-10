import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
//        int N = Integer.parseInt(br.readLine());
        int N = sc.nextInt();
        StringBuilder number = new StringBuilder();


        for (int i = 0; i < N; i++) {
            number.append(sc.next());
        }

        int i = 0;
        for (; ; i++) {
            String tmp = String.valueOf(i);
            if (number.indexOf(tmp) == -1) {
                break;
            }
        }
        System.out.println(i);

    }
}