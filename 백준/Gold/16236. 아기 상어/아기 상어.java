import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map; // 원본 배열
    static int[][] distance; // 여러 물고기가 있을 때 거리를 체크하는 배열

    // 상,하,좌,우 확인
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    static int N;
    // 상어의 위치 좌표
    static int sharkX, sharkY;
    // 걸린시간 및 상어가 먹은 횟수와 사이즈
    static int time, count, size = 2;
    // 상어가 먹을 수 있는 가장 가까운 물고기 좌표
    static int minX, minY, minDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    // 상어가 있었던 위치는 0으로 설정해준다.
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            distance = new int[N][N];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDistance = Integer.MAX_VALUE;

            bfs();

            // minX,minY가 초기값과 같다면 더 이상 먹을 물고기 없음
            if(minX == Integer.MAX_VALUE || minY == Integer.MAX_VALUE){
                break;
            }

            // 먹은 카운트 증가 현재 사이즈와 같다면 0으로 초기화 및 사이즈 크기 증가
            count++;
            if(count == size){
                count = 0;
                size++;
            }


            // 현재 상어 위치 갱신
            sharkX = minX;
            sharkY = minY;
            // 먹은 상어 제거
            map[minX][minY] = 0;

            // 횟수 더하기
            time += distance[minX][minY];
        }

        System.out.println(time);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sharkX, sharkY});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                // 배열 범위 밖이라면 Out
                if (nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
                // 현재 사이즈보다 크다면 지나갈 수 없음
                if(map[nX][nY] > size) continue;
                // 방문한 적 있다면 방문 X
                if(distance[nX][nY] != 0) continue;

                distance[nX][nY] = distance[cur[0]][cur[1]] + 1;

                // 해당 위치에 물고기가 존재하고 더 작으면 먹을 수 있음
                if(map[nX][nY] != 0 && map[nX][nY] < size){
                    // 더 가깝다면 갱신
                    if(minDistance > distance[nX][nY]){
                        minDistance = distance[nX][nY];
                        minX = nX;
                        minY = nY;
                    }
                    // 최소 거리가 같다면 X가 작은 순서로
                    else if (minDistance == distance[nX][nY]) {
                        if(minX > nX){
                            minX = nX;
                            minY = nY;
                        }
                        // X가 같다면 Y가 작은 순서로
                        else if(minX == nX && minY > nY){
                            minX = nX;
                            minY = nY;
                        }
                    }
                }

                queue.add(new int[]{nX, nY});
            }
        }
    }
}