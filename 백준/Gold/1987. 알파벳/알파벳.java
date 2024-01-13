import java.io.*;
import java.util.*;

class Main {
    // 알파벳을 저장하기 위한 배열
    static boolean[] alphabet;
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
        alphabet = new boolean[26];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        // 스타트 지점은 미리 방문 처리를 해준다.
        alphabet[map[0][0] - 'A'] = true;
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
            if(isValid(nX,nY) || alphabet[map[nX][nY]-'A']){
                continue;
            }

            // 이미 지나온 알파벳으로 처리를 해준 뒤 재귀 호출
            alphabet[map[nX][nY]-'A'] = true;
            searchRoute(nX, nY, count + 1);
            // 안지나온 알파벳으로 갱신한다.
            alphabet[map[nX][nY]-'A'] = false;
        }
        // result값을 최대값으로 갱신한다.
        result = Math.max(count,result);
    }

    // x,y가 배열 범위밖에 있다면 true 유효하다면 false;
    private static boolean isValid(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}