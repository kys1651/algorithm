import java.io.*;
import java.util.*;

/*
	작성자 : 김용수
	문제 : [백준] 17829번 : 222-풀링 Silver2(실버2)
	제출 : 
	결과 : 맞았습니다!!
	성능 요약 : 
	
	접근 방법
	1. N은 2의배수로 줄어든다. recursion case와 base condition을 나눠야함
	2. recursion case는 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 분면들로 나눈다.
	3. 해당 분면들의 풀링 값을 리턴 받고 그 값들의 풀링값을 찾는다.
	3. base condition은 N이 1일 때  값을 리턴하면 된다.
*/

public class Main {
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i =0 ;i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(recursion(0,0,n));
	}
	private static int recursion(int x, int y, int len) {
		if(len == 1) {
			return map[x][y];
		}
		int nextLen = len / 2;
		int[] arr = new int[] {recursion(x,y,nextLen),recursion(x,y+nextLen,nextLen),recursion(x+nextLen,y,nextLen),recursion(x+nextLen, y + nextLen, nextLen)};
		Arrays.sort(arr);
		return arr[2];
	}
}
