import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = n / 5;
        n %= 5;
        answer += n / 4;
        n %= 4;
        answer += n / 3;
        n %= 3;
        answer += n / 2;
        n %= 2;
        answer += n ;
        System.out.println(answer);
    }
}