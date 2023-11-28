import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i = 0; i < n ;i++){
            map[i] = br.readLine().toCharArray();
        }
        System.out.println(recursion(n,0,0));
    }

    private static String recursion(int n, int x, int y) {
        char mark  = map[x][y];
        boolean check = true;
        loop : for(int i = x; i < x + n; i++){
            for(int j = y;j < y + n; j++){
                if(mark != map[i][j]){
                    check = false;
                    break loop;
                }
            }
        }
        if(check || n == 1){
            return String.valueOf(mark);
        }
        StringBuilder sb = new StringBuilder("(");

        int size = n / 2;
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                sb.append(recursion(size,i,j));
            }
        }

        return sb.append(")").toString();

    }
}