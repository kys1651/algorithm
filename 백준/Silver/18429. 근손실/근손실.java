import java.util.*;
import java.io.*;

public class Main {
    static int n,k,result;
    static int[] kit, arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        kit = new int[n];
        arr = new int[n];
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }
        searchSet(0);
        System.out.println(result);
    }

    private static void searchSet(int depth) {
        if (depth == n) {
            if(checkUnder()){
                result++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            arr[depth] = i;
            searchSet(depth + 1);
            visit[i] = false;
        }
    }

    private static boolean checkUnder() {
        int muscle = 500;
        for (int i = 0; i < n; i++) {
            muscle += kit[arr[i]];
            muscle -= k;
            if (muscle < 500) {
                return false;
            }
        }
        return true;
    }
}
