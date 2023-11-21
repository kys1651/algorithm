import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i = 0 ; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs(arr));
    }

    private static int bfs(int[] arr) {
        // 합이 3으로 나누어지지 않는다면 결과는 0
        int sum = arr[0] + arr[1] + arr[2];
        if(sum % 3 != 0){
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(arr);

        // 방문하는 배열은 2차원 배열이여도 됨 why? 어차피 돌의 개수는 고정이니까 두개의 합 + 나머지의 합 -> 총합
        boolean[][] visit = new boolean[sum+1][sum+1];
        visit[arr[0]][arr[1]] = true;

        while(!queue.isEmpty()){
            int[] ns = queue.poll();
            int x = ns[0];
            int y = ns[1];
            int z = ns[2];

            // 3개가 모두 같다면 return 1
            if(x == y && y == z){
                return 1;
            }

            /*
                개수가 다르면 연산을 처리 후 방문을 했다고 남김(만약 방문한 곳을 또 방문(연산한 값을 또 연산)하는 것은 의미가 없기 때문에
                방문 배열을 통해서 계산 안해본 경우만 계산 후 큐에 삽입
             */
            // 갯수가 다른 연산
            if(x != y){
                int nx = x > y ? x - y : x + x;
                int ny = x > y ? y + y : y - x;

                if(!visit[nx][ny]){
                    queue.offer(new int[] {nx,ny,z});
                    visit[nx][ny] = true;
                }
            }
            if(y != z){
                int ny = y > z ? y - z : y + y;
                int nz = y > z ? z + z : z - y;

                if(!visit[ny][nz]){
                    queue.offer(new int[] {x,ny,nz});
                    visit[ny][nz] = true;
                }
            }
            if(x != z){
                int nx = x > z ? x - z : x + x;
                int nz = x > z ? z + z : z - x;

                if(!visit[nx][nz]){
                    queue.offer(new int[]{nx,y,nz});
                    visit[nx][nz] = true;
                }
            }
        }

        return 0;
    }
}