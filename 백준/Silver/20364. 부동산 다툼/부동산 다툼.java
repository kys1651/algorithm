import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[n + 1];

        while (q-- > 0) {
            sb.append(getIdx(Integer.parseInt(br.readLine()), visit)).append('\n');
        }
        System.out.println(sb);
    }

    private static int getIdx(int x, boolean[] visit) {
        int rt = 0, move = x;
        while (move != 1) {
            if (visit[move]) rt = move;
            move /= 2;
        }
        if (rt == 0) visit[x] = true;
        return rt;
    }
}