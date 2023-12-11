import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[101][101];
        StringTokenizer st;
        for (int n = 1; n <= 4; n++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for(int i = a; i < c; i++){
                for(int j = b; j < d; j++){
                    map[i][j] = 1;
                }
            }
        }
        int count = 0;
        for (int[] ns : map) {
            for (int n : ns) {
                if(n==1) count++;
            }
        }
        System.out.println(count);
    }
}