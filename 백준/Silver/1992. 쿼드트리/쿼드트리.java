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
        // (x,y)위치 값을 변수에 저장하여 확인
        char mark  = map[x][y];
        // 전부가 같은지 아닌지 확인하는 flag
        boolean check = true;
        loop : for(int i = x; i < x + n; i++){
            for(int j = y;j < y + n; j++){
                if(mark != map[i][j]){
                    // 다르다면 for문 종료
                    check = false;
                    break loop;
                }
            }
        }
        // 같다면 ( n == 1처럼 쪼개질 수 없을 때도 포함) return 
        if(check){
            return String.valueOf(mark);
        }
        // 아니라면 분할한 값들을 괄호안에 씌어야함으로 ( 초기화
        StringBuilder sb = new StringBuilder("(");

        // size로 나눠서 초기화 해줌
        int size = n / 2;
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                sb.append(recursion(size,i,j));
            }
        }

        // ) 를 붙여서 리턴
        return sb.append(")").toString();

    }
}