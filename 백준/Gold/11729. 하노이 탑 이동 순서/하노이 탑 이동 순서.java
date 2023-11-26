import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n,1,2,3);
        System.out.println(result);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, int start, int mid, int to){
        result++;
        if(n == 1){
            sb.append(start + " " + to).append("\n");
            return;
        }
        hanoi(n-1,start,to,mid);
        sb.append(start + " " + to).append("\n");
        hanoi(n-1,mid,start,to);
    }
}
