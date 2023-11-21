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
        int sum = arr[0] + arr[1] + arr[2];
        if(sum % 3 != 0){
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(arr);

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