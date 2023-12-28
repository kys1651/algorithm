import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    // 상하좌우
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    // 시작 지점과 목표 지점
    static int[] start = new int[2],end =  new int[2];
    // 바다를 저장 할 map
    static int[][] map;
    // 방문을 확인 할 visit
    static boolean[][] visit;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // N을 입력 받고 크기의 map, visit 생성
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 시작, 출발 지점을 입력 받음
            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            // 만약 출발지점과 시작지점이 같다면 StringBuilder에 추가 후 Continue;
            if (start[0] == end[0] && start[1] == end[1]) {
                sb.append("#" + tc + " " + 0);
                continue;
            }
            
            sb.append("#" + tc + " " + searchRoute()).append("\n");
        }
        System.out.println(sb);
    }

    private static int searchRoute() {
        // 시작 지점 추가 및 방문 처리
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        visit[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int time = cur[2];

            // 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                // 경계 밖이거나 방문했거나 장애물이면 continue;
                if (check(nX, nY) || visit[nX][nY] || map[nX][nY] == 1) {
                    continue;
                }

                // 목표지점에 도착했다면 return
                if (nX == end[0] && nY == end[1]) {
                    return time + 1;
                }

                // 소용돌이일 때
                if (map[nX][nY] == 2) {
                    // % 3 == 2라면 지나갈 수 있는 시간
                    if (time % 3 == 2) {
                        visit[nX][nY] = true;
                        queue.add(new int[]{nX, nY, time + 1});
                    }
                    // 2가 아니라면 지나갈 수 없음 기다려야한다.
                    else {
                        visit[cur[0]][cur[1]] = true;
                        queue.add(new int[]{cur[0],cur[1],time+1});
                    }
                }
                // 소용돌이가 아니라면 바로 방문처리
                else {
                    visit[nX][nY] = true;
                    queue.add(new int[]{nX, nY, time + 1});
                }
            }
        }
        // 만약 목표지점에 방문 못한다면 -1 return
        return -1;
    }

    private static boolean check(int x, int y) {
        return x < 0 || x >= map.length || y < 0 || y >= map[x].length;
    }
}