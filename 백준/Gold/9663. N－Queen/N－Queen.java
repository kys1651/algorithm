import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int N;
    static int[] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N];

        NQueen(0);

        System.out.println(count);
    }

    private static void NQueen(int pos) {
        if(pos == N){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            map[pos] = i;
            if(checkQueen(pos)){
                NQueen(pos+1);
            }
        }


    }

    private static boolean checkQueen(int pos) {
        for(int i = 0; i < pos; i++){
            if(map[i] == map[pos])
                return false;
            else if(Math.abs(i-pos) == Math.abs(map[i]- map[pos]))
                return false;
        }

        return true;
    }
}
