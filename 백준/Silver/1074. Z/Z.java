import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2,n);
        System.out.println(z(size,r,c));
    }

    private static int z(int n,int r, int c) {
        // n == 0이면 return
        if(n == 0) return 0;
        // half는 현재 보고 있는 배열의 길이의 절반
        int half = (int)Math.pow(2,n-1);
        // 1사분면
        if(r < half && c < half) return z(n-1,r,c);
        // 2사분면에 위치한다면 1사분면에 넓이와 r,c에 위치를 더함
        else if(r < half && c >= half) return half * half + z(n-1,r,c - half);
        // 3사분면에 위치한다면 1,2사분면에 넓이를 더하고 r,c에 위치를 더 함
        else if(r >= half && c < half) return 2 * half * half + z(n-1,r-half,c);
        // 4사분면에 위치한다면 1,2,3사분면에 넓이를 더하고 r,c위치를 찾아 더함
        else return 3 * half * half + z(n-1,r-half,c-half);
    }
}
