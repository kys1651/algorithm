import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,b;
    static int[][] map;
    static int time = Integer.MAX_VALUE;
    static int height = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                start = Math.min(start, map[i][j]);
                end = Math.max(end, map[i][j]);
            }
        }
        for (; start <= end; start++) {
            groundCheck(start);
        }

        System.out.println(time + " " + height);
    }

    private static void groundCheck(int ground) {
        int tmpTime = 0;
        int block = b;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (map[i][j] >= ground) {
                    int gap = map[i][j] - ground;
                    tmpTime += 2 * gap;
                    block += gap;
                } else{
                    int gap = ground - map[i][j];
                    tmpTime += gap;
                    block -= gap;
                }
            }
        }
        if(block < 0 || tmpTime > time){
            return;
        }

        time = tmpTime;
        height = ground;
    }
}