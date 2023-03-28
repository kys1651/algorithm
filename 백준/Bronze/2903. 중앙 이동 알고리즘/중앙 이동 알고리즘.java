import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int answer = 2;
        for(int i = 0 ; i < n ; i++){
            answer = answer + (answer - 1);
        }
        System.out.println(answer * answer);
    }
}