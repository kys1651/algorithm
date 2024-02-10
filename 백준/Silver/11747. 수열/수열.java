import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder number = new StringBuilder();

        int count = 0;
        while (count != N) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                number.append(st.nextToken());
                count++;
            }
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