import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] map;
    static boolean[][] visit;
    static boolean[] keys;
    static ArrayList<Point>[] gates;
    static int result;
    static int[] dirX = {-1,1,0,0};
    static int[] dirY ={0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int h = sc.nextInt();
            int w = sc.nextInt();

            map = new char[h+2][w+2];
            visit = new boolean[h+2][w+2];
            keys = new boolean[26];
            gates = new ArrayList[26];

            result = 0;
            for(int i = 0; i < 26; i++){
                gates[i] = new ArrayList<>();
            }

            for(int i = 0; i < h + 2; i++){
                for(int j = 0; j < w + 2; j++){
                    map[i][j] = '.';
                }
            }
            for(int i = 1; i <= h; i++){
                String input = sc.next();
                for(int j = 1; j <= w; j++){
                    map[i][j] = input.charAt(j - 1);
                }
            }

            String key = sc.next();
            if(!key.equals("0")){
                for(int i = 0; i < key.length(); i++){
                    keys[key.charAt(i) - 'a'] = true;
                }
            }

            go();
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void go() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        visit[0][0] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i = 0 ; i < 4; i++){
                int nx = p.x + dirX[i];
                int ny = p.y + dirY[i];

                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length){
                    continue;
                }
                if(map[nx][ny] == '*' ||visit[nx][ny]){
                    continue;
                }

                char pos = map[nx][ny];
                if(pos >= 'A' && pos <= 'Z'){
                    if(keys[pos-'A']){
                        map[nx][ny] = '.';
                        visit[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }else{
                        gates[pos - 'A'].add(new Point(nx, ny));
                    }
                }else if(pos >= 'a' && pos <= 'z'){
                    keys[pos - 'a'] = true;
                    visit[nx][ny] = true;
                    queue.add(new Point(nx,ny));

                    for(int j = 0; j < 26; j++){
                        if(gates[j].size()!=0 && keys[j]){
                            for(int k = 0; k < gates[j].size(); k++){
                                Point open = gates[j].get(k);
                                map[open.x][open.y] = '.';
                                visit[open.x][open.y] = true;
                                queue.offer(new Point(open.x, open.y));
                            }
                        }
                    }
                }else if(pos == '$'){
                    result++;
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }else{
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}