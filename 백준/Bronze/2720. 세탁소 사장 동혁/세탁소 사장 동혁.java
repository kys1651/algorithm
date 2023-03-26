import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());

            sb.append(C / 25 + " ");
            C %= 25;
            sb.append(C / 10 + " ");
            C %= 10;
            sb.append(C / 5 + " ");
            C %= 5;
            sb.append(C + "\n");
        }
        System.out.println(sb);
    }
}