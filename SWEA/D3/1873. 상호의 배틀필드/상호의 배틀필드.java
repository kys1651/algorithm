import java.util.Scanner;
class Solution
{
    // 상,하,좌,우
    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};
    static int tankDir,tankX,tankY;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int h = sc.nextInt();
            int w = sc.nextInt();
            tankDir = 0;tankX = 0;tankY = 0;
            char[][] map = new char[h][w];
            for(int i = 0; i < h; i++){
                String line = sc.next();
                for(int j = 0; j < w; j++){
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == '^'){
                        tankDir = 0;
                        tankX = i; tankY = j;
                    }else if(map[i][j] == 'v'){
                        tankDir = 1;
                        tankX = i; tankY = j;
                    }else if(map[i][j] == '<'){
                        tankDir = 2;
                        tankX = i; tankY = j;
                    }else if(map[i][j] == '>'){
                        tankDir = 3;
                        tankX = i; tankY = j;
                    }
                }
            }
            int n = sc.nextInt();
            String line = sc.next();
            for(int i = 0; i < n; i++){
                if(line.charAt(i) == 'S'){
                    shoot(map);
                }else{
                    forward(line.charAt(i),map);
                }
            }
            System.out.print("#" + tc + " ");
            printMap(map);
        }
	}
    private static void printMap(char[][] map){
        for(char[] str : map){
                System.out.println(new String(str));
            }
    }
    private static boolean isCheck(int x, int y,char[][] map){
        return x >= 0 && x < map.length && y >= 0 && y < map[x].length ;
    }
    
    private static void shoot(char[][] map){
        int nx = tankX + dirX[tankDir];
        int ny = tankY + dirY[tankDir];
        while(isCheck(nx,ny,map)){
            if(map[nx][ny] == '*'){
                map[nx][ny] = '.';
                return;
            }else if(map[nx][ny] == '#'){
                return;
            }
            nx += dirX[tankDir];
            ny += dirY[tankDir];
        }
    }
    
    private static void forward(char d, char[][] map){
        char mark = ' ';
        switch(d){
            case 'U': tankDir = 0; mark = '^'; break;
            case 'D': tankDir = 1; mark = 'v'; break;
            case 'L': tankDir = 2; mark = '<'; break;
            case 'R': tankDir = 3; mark = '>'; break;
            default: break;
        }
        map[tankX][tankY] = mark;
        int nx = dirX[tankDir] + tankX;
        int ny = dirY[tankDir] + tankY;
        if(!isCheck(nx,ny,map)){
            return;
        }
        if(map[nx][ny] == '.'){
            map[nx][ny] = mark;
            map[tankX][tankY] = '.';
            tankX = nx;
            tankY = ny;
        }
    }
}