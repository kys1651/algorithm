import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] text = new char[5][];

        // 가장 긴 문자열의 길이
        int max = 0;
        for (int i = 0; i < 5; i++) {
            // 문자열들을 문자 배열로 만들어서 넣어줌
            text[i] = br.readLine().toCharArray();
            max = Math.max(text[i].length, max);
        }

        // 가장 긴 길이까지 확인
        for (int i = 0; i < max; i++) {
            // 5개의 배열 중 현재 길이보다 짦다면 넘어감
            for(int j = 0; j < 5 ;  j++) {
                if(i >= text[j].length){
                    continue;
                }
                sb.append(text[j][i]);
            }
        }
        System.out.println(sb);
    }
}
