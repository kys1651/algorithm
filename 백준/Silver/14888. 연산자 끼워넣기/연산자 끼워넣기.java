import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int number[];
    static int operator[] = new int[4];
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        solution(number[0],  1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void solution(int num, int idx) {
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return ;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {

                operator[i]--;

                switch (i) {

                    case 0: solution(num + number[idx], idx + 1 ); break;
                    case 1: solution(num - number[idx], idx + 1 ); break;
                    case 2: solution(num * number[idx], idx + 1 ); break;
                    case 3: solution(num / number[idx], idx + 1 ); break;
                }
                operator[i]++;
            }
        }

    }
}
