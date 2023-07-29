import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static String[] arr;
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");

        visited = new boolean[10];

        solution(0,"");

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    private static void solution(int index, String num) {
        if (index == N + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(visited[i]) continue;

            //
            if (index == 0 || check(num.charAt(index - 1) - '0', i, arr[index - 1])) {
                visited[i] = true;
                solution(index + 1, num + i);
                visited[i] = false;
            }
        }
    }

    // a : 전 숫자
    // b : 현재 숫자
    // c : 부등호
    private static boolean check(int a, int b, String c) {
        if(c.equals(">") && a < b)
            return false;
        if(c.equals("<") && a > b)
            return false;

        return true;
    }
}


