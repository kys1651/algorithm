import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int N;
    static int start = 1;
    static int end = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());

        solution("");

    }

    private static void solution(String str) {
        // 문자열의 길이가 N이 되면 처음 나온 좋은 수열이 최소값이므로 출력 후 프로그램 종료
        if(str.length() == N){
            System.out.println(str);
            System.exit(0);
        }

        for (int i = start; i <= end; i++) {
            if(Make(str+i)){ // 좋은 숫자를 추가 했을 때 좋은 수열이라면 재귀함수
                solution(str + i);
            }
        }


    }

    private static boolean Make(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if(front.equals(back)) return false;
        }
        return true;
    }

}
