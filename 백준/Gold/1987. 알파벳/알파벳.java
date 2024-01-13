import java.io.*;
import java.util.*;

class Main {
    // 알파벳을 저장하기 위한 Set
    static HashSet<Character> set = new HashSet<>();
    // 알파벳을 입력받기 위한 map
    static char[][] map;

    // 네가지 방향을 저장해줌
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static int n,m,result;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        // 스타트 지점은 미리 넣어준다.
        set.add(map[0][0]);
        // 시작 지점을 포함한 1부터 시작
        searchRoute(0,0,1);
        System.out.println(result);
    }

    // 백트래킹으로 경로를 찾는 메서드
    private static void searchRoute(int x, int y, int count) {
        // 상,하,좌,우순으로 실행한다.
        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            // nX,nY가 배열 범위 밖에 있거나 || 같은 알파벳을 지나온 적 있다면 넘어간다.
            if(isValid(nX,nY) || set.contains(map[nX][nY])){
                continue;
            }

            // 경로에 다음 위치를 포함해준 뒤 재귀 호출
            set.add(map[nX][nY]);
            searchRoute(nX, nY, count + 1);
            // 다시 set에서 지워주어 배열의 상태를 원래로 만든다.
            set.remove(map[nX][nY]);
        }
        // result값을 최대값으로 갱신한다.
        result = Math.max(count,result);
    }

    // x,y가 배열 범위밖에 있다면 true 유효하다면 false;
    private static boolean isValid(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}