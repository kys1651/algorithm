import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];
        String answer = "";
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 8; i++) {
            if (arr[0] == 1 && arr[i] == (i+1)) {
                continue;
            }
            if (arr[0] == 8 && arr[i] == (8 - i)) {
                continue;
            }

            answer = "mixed";
            break;
        }

        if (!answer.equals("mixed")) {
            if (arr[0] == 1) {
                answer = "ascending";
            } else if (arr[0] == 8) {
                answer = "descending";
            }
        }

        System.out.println(answer);
    }
}
