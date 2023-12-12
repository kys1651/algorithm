import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n,blue,white;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int x, int y, int size) {
        int check = map[x][y];
        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if(check != map[i][j]){
                    int next = size/2;
                    divide(x,y,next);
                    divide(x + next, y, next);
                    divide(x, y + next, next);
                    divide(x+next,y+next,next);
                    return;
                }
            }
        }
        if(check == 1){
            blue++;
        }else{
            white++;
        }
    }
}