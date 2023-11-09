import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{ 
    static char[][] map;
    static boolean[] visit,check;
    static int[] select;
    static int result;
    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        for(int i = 0; i < 5; i++){
            map[i] = br.readLine().toCharArray();
        }
        visit = new boolean[25];
        select = new int[7];
        find(0,0,0);
        System.out.println(result);
    }
    // 가능한 조합 7개 뽑기
    private static void find(int idx, int count, int s) {
        if(count == 7){
            if(s >= 4){
                if(checkLink()){
                    result++;
                }
            }
            return;
        }

        for(int i = idx; i < 25; i++){
            visit[i] = true;

            // 선택
            select[count] = i;

            // 다솜파인지 확인
            if(map[i/5][i%5]=='S'){
                find(i+1,count+1,s+1);
            }else{
                find(i+1,count+1,s);
            }

            visit[i] = false;
        }
    }

    private static boolean checkLink(){
        Queue<Integer> q = new LinkedList<>();
        q.add(select[0]);
        int count = 1;
        check = new boolean[25];
        
        while(!q.isEmpty()){
            int now = q.poll();
            check[now] = true;

            for(int i = 0; i < 4; i++){
                int nx = (now/5) + dirX[i];
                int ny = (now%5) + dirY[i];

                if(nx < 0 || nx >= 5 || ny <0 || ny >=5){
                    continue;
                }
                int nextPos = nx * 5 + ny;
                if(check[nextPos] || !visit[nextPos]) continue;

                count++;
                check[nextPos] = true;
                q.add(nextPos);
            }
        }

        return count == 7;
    }
}
