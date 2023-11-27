import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer[] = new int[3];
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine()," " );
            for(int j = 0; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(n,0,0);
        for(int i = 0; i <3; i++){
            System.out.println(answer[i]);
        }
    }

    private static void recursion(int n,int x,int y) {
        if(n == 1){
            answer[map[x][y]+1]++;
            return;
        }

        boolean check = true;
        int size = n/3;
        int mark = map[x][y];
        loop: for(int i = x; i < x+n; i++){
            for(int j = y; j < y+n; j++){
                if(mark != map[i][j]){
                    check = false;
                    break loop;
                }
            }
        }
        if(check){
            answer[mark+1]++;
            return;
        }

        for(int i = x; i < x + n; i += size){
            for (int j = y; j < y + n; j += size) {
                recursion(size,i,j);
            }
        }



    }

}