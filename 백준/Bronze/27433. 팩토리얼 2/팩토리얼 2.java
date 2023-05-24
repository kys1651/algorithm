import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());

        Long answer = solution(n);
        System.out.println(answer);
    }

    private static Long solution(int n) {
        if(n == 0) return 1L;

        return solution(n - 1) * n;
    }

}
