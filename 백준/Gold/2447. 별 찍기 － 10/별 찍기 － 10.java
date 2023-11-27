import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        print(n,0,0,false);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void print(int n,int x,int y,boolean space) {
        if(space){
            for(int i = x; i < x+n; i ++){
                for (int j = y; j < y + n; j++) {
                    map[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1){
            map[x][y] = '*';
            return;
        }




        int size = n/3;
        int count = 0;
        for(int i = x; i < x + n; i += size){
            for (int j = y; j < y + n; j += size) {
                count++;
                if(count == 5){
                    print(size, i, j, true);
                }else{
                    print(size,i,j,false);
                }
            }
        }
    }

}