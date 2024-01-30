import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] num;
    static boolean[] visit;
    static HashSet<Integer> possibleNum = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        visit = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0, 0);

        int idx = 1;
        while(possibleNum.contains(idx)){
            idx++;
        }
        System.out.println(idx);
    }

    private static void combination(int depth, int at, int sum) {
        for (int i = at; i < n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            combination(depth + 1, i + 1, sum + num[i]);
            visit[i] = false;
        }
        possibleNum.add(sum);
    }
}