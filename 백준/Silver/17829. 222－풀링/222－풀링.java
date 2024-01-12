import java.io.*;
import java.util.*;

class Main{
	static int[][] map;
	static int[][] answer;
	static int n;
	
    public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	map = new int[n][n];
        for(int i = 0 ; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j <n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        recursion();
        
    }
    private static void recursion() {
    	if(n == 1) {
    		System.out.println(answer[0][0]);
    		return;
    	}
    	answer = new int[n/2][n/2];
    	recursionMake(0,0,n);
    	map = answer;
    	n /= 2;
    	recursion();
    }
	
    private static void recursionMake(int x,int y, int len) {
    	if(len == 2) {
    		searchSecondMax(x,y);
    		return;
    	}
    	len /= 2;
    	recursionMake(x,y,len);
    	recursionMake(x+len,y,len);
    	recursionMake(x,y+len,len);
    	recursionMake(x+len,y+len,len);
    }
    
    private static void searchSecondMax(int x,int y) {
    	int[] nums = new int[] {map[x][y], map[x][y+1],map[x+1][y], map[x+1][y+1]};
    	Arrays.sort(nums);
    	answer[x / 2][y/2] = nums[2];
    }
}