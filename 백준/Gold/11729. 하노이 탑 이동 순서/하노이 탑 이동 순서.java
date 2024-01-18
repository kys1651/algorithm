import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n,1, 3, 2);
        System.out.println((int) (Math.pow(2, n) - 1));
        System.out.println(sb);
    }

    // num을 cur에서 goal로 옮기기
    private static void hanoi(int num,int cur, int goal, int middle) {
        count++;
        // num이 1이면 자유롭게 이동가능한 경우
        if(num == 1){
            sb.append(cur + " " + goal + "\n");
            return;
        }

        // num이 1이 아닌 경우 위에 숫자 N-1들을 중간 지점에 옮겨줘야한다.
        hanoi(num - 1, cur, middle, goal);
        // 그럼 현재 num을 옮길 수 있음
        sb.append(cur + " " + goal + "\n");
        // middle에 있는 탑들을 지금 목적지로 옮겨줘야한다.
        hanoi(num - 1, middle, goal, cur);
    }
}
