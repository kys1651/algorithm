import java.util.*;
import java.io.*;

public class Main {
    static int n,k,result;
    static int[] kit, arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N개의 운동 키트
        n = Integer.parseInt(st.nextToken());
        // 하루에 감소하는 근육량
        k = Integer.parseInt(st.nextToken());
        // 운동 키트
        kit = new int[n];
        // 키트 순서를 저장 할 배열
        arr = new int[n];
        // DFS시 사용 할 방문 배열
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }
        searchSet(0);
        System.out.println(result);
    }

    // 키트 순서 조합을 만들어주는 dfs 메서드
    private static void searchSet(int depth) {
        // n개만큼 찾는다면 키트를 사용해서 500 밑으로 떨어지는지 확인 떨어지지않는다면 result++;
        if (depth == n) {
            if(checkUnder()){
                result++;
            }
            return;
        }

        // 0 ~ n까지 방문하지 않는 배열을 찾아갈 것.
        for (int i = 0; i < n; i++) {
            // 방문했다면 continue;
            if(visit[i]) continue;

            // 방문하지않았다면 방문 처리
            visit[i] = true;
            // 순서배열에 현재 키트를 넣어줌
            arr[depth] = i;
            // 재귀 호출 후 방문 처리를 풀어줘야한다.
            searchSet(depth + 1);
            visit[i] = false;
        }
    }

    // 키트를 사용해서 상태가 유효한지 확인하는 메서드
    private static boolean checkUnder() {
        // 기본값은 500
        int muscle = 500;
        for (int i = 0; i < n; i++) {
            // 키드 사용 후 하루에 감소하는 근육량도 빼준다.
            muscle += kit[arr[i]] - k;
            // 500미만이라면 더이상 유효하지 않으므로 return false;
            if (muscle < 500) {
                return false;
            }
        }
        return true;
    }
}
