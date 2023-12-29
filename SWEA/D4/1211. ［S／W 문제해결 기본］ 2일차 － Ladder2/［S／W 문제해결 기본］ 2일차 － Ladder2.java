import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Solution {
    static int[][] map;
    static int distance, answer;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            br.readLine();
            // 사다리 배열
            map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // distance : 최소값을 구하기 위해 최대값으로 초기화
            distance = 10000;
            answer = 0;
            // 출발 지점 마주치면 시작
            for (int i = 0; i < 100; i++) {
                if (map[0][i] == 1) {
                    dfs(i);
                }
            }
            sb.append("#" + tc + " " + answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start) {
        // (0,start)에서 시작
        int x = 0;
        int y = start;
        // 총 이동거리를 저장 할 count
        int count = 0;
        // map 거리만큼 이동
        while (x < 100) {
            // 왼쪽에 사다리 존재시 쭉 이동한다.
            if( y - 1 >= 0 && map[x][y-1] == 1){
                while(y - 1 >= 0 && map[x][y-1] == 1){
                    y--;
                    count++;
                }
            }
            // 오른쪽에 사다리 존재시 쭉 이동해준다.
            else if (y + 1 < 100 && map[x][y + 1] == 1) {
                while (y + 1 < 100 && map[x][y + 1] == 1) {
                    count++;
                    y++;
                }
            }
            // 이동 후 한칸 내려감과 동시에 count++
            x++;
            count++;
        }

        // distance 갱신 가능하다면 해줌.
        if (distance >= count) {
            distance = count;
            answer = start;
        }
    }
}