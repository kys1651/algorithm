import java.util.*;
import java.io.*;

public class Main {
    static int[][] friends;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        friends = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            friends[a][b] = friends[b][a] = 1;
        }

        floydWarshall();

        int count = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp += friends[i][j];
            }
            if(count > tmp){
                count = tmp;
                answer = i + 1;
            }
        }
        System.out.println(answer);
    }

    private static void floydWarshall() {
        // 거쳐야 할 유저의 번호
        for (int k = 0; k < n; k++) {
            // 시작 유저
            for (int i = 0; i < n; i++) {
                // 거쳐야 할 유저가 본인이거나 거쳐야 할 유저랑 연결이 되어있지 않다면 넘어간다.
                if (k == i || friends[i][k] == 0) continue;

                // 종료 유저
                for (int j = 0; j < n; j++) {
                    // 거쳐서 본인을 갈 필요는 없음
                    if (j == i) {
                        continue;
                    }
                    // 거쳐서 갈 수 있는 경우
                    if (friends[i][k] != 0 && friends[k][j] != 0) {
                        // 기존에 연결되어있지 않다면 그냥 연결
                        if (friends[i][j] == 0) {
                            friends[i][j] = friends[i][k] + friends[k][j];
                        }
                        // 기존에 연결되어있다면 최소값으로 연결
                        else {
                            friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
                        }
                    }
                }
            }
        }
    }
}
