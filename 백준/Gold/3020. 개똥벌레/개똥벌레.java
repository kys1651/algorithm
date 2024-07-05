import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] down = new int[H + 2];
        int[] top = new int[H + 2];

        for (int i = 1; i <= (N / 2); i++) {
            int a = Integer.parseInt(br.readLine());
            int b = H - Integer.parseInt(br.readLine()) + 1;
            down[a]++;
            top[b]++;
        }
        for (int i = 1; i <= H; i++) {
            down[i] += down[i - 1];
        }
        for(int i = H; i >= 1; i--) {
            top[i] += top[i + 1];
        }

        int min = N;
        int count = 0;
        for (int i = 1; i <= H; i++) {
            int diff = (down[H] - down[i - 1]) + (top[1] - top[i + 1]);

            if(diff < min){
                min = diff;
                count = 1;
            }else if(diff==min) {
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(' ').append(count);
        System.out.println(sb);
    }
}