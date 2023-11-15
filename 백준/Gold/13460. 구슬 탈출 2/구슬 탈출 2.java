import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{ 
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y= y;
        }
    }
    static class Game{
        Point red;
        Point blue;
        int count;

        public Game(Point red, Point blue, int count) {
            this.red = red;
            this.blue = blue;
            this.count = count;
        }
    }
    static int n,m;
    static char[][] map;
    static int result;
    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        result = Integer.MAX_VALUE;
        Point blue = null;
        Point red = null;
        for(int i = 0; i < n; i++){
            String line = sc.next();
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'B'){
                    map[i][j] = '.';
                    blue = new Point(i, j);
                }else if(map[i][j] == 'R'){
                    map[i][j] = '.';
                    red = new Point(i, j);
                }
            }
        }
        bfs(new Game(red, blue, 0));
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
    private static void bfs(Game game) {
        Queue<Game> queue = new LinkedList<>();
        queue.offer(game);

        while(!queue.isEmpty()){
            Game curGame = queue.poll();
            Point curRed = curGame.red;
            Point curBlue = curGame.blue;
            if(curGame.count > 9){
                continue;
            }
            

            // 방향별로 한번씩 기울여줌
            for(int i = 0; i < 4; i++){

                // 게임 시작 할  때 초기화 해
                map[curRed.x][curRed.y] = 'R';
                map[curBlue.x][curBlue.y] = 'B';
                int nRX = curRed.x;
                int nRY = curRed.y;
                int nBX = curBlue.x;
                int nBY = curBlue.y;
                boolean blueGoal = false;
                boolean redGoal = false;
                while(true){
                    boolean change = false;
                    // 움직였는지 확인하는 상태 
                    if(!redGoal){
                        char nextRed = map[nRX + dirX[i]][nRY+dirY[i]];
                        if(nextRed == '.'){
                            change = true;
                            map[nRX+dirX[i]][nRY+dirY[i]] = 'R';
                            map[nRX][nRY] = '.';
                            nRX += dirX[i];
                            nRY += dirY[i];
                        } else if(nextRed == 'O'){
                            map[nRX][nRY] = '.';
                            redGoal = true;
                            change = true;
                        }
                    }
                    if(!blueGoal){
                        char nextBlue = map[nBX + dirX[i]][nBY+dirY[i]];
                        if(nextBlue == '.'){
                            change = true;
                            map[nBX+dirX[i]][nBY+dirY[i]] = 'B';
                            map[nBX][nBY] = '.';
                            nBX += dirX[i];
                            nBY += dirY[i];
                        } else if(nextBlue == 'O'){
                            map[nBX][nBY] = '.';
                            blueGoal = true;
                            break;
                        }
                    }

                    if(!change) break;
                }

                
                // 원상복구
                map[nRX][nRY] = '.';
                map[nBX][nBY] = '.';

                if(blueGoal){
                    continue;
                }
                if(redGoal){
                    result = Math.min(result,curGame.count+1);
                }
                
                if(nRX == curRed.x && nRY == curRed.y && nBX == curBlue.x && nBY == curBlue.y){
                    continue;
                }
                queue.offer(new Game(new Point(nRX, nRY), new Point(nBX, nBY), curGame.count+1));
            }

        }
    }
    private static void printMap() {
        for(char[] ms: map){
            for(char m : ms){
                System.out.print(m);
            }
            System.out.println();
        }
        System.out.println();
    }
}
