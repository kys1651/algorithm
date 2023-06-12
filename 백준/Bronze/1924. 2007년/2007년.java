import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String[] answer = {"MON", "TUE", "WED", "THU", "FRI", "SAT","SUN"};
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int n = y - 1;
        for (int i = 0; i < x; i++) {
            n += months[i];
        }

        System.out.println(answer[n % 7]);

    }
}
