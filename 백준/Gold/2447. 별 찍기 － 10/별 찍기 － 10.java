import java.io.*;
import java.util.*;

class Main{
	static char[][] map;
    public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
    	map = new char[n][n];
    	
    	recursion(0,0,0,n);
    	for(int i = 0; i < map.length; i++) {
    		for(int j = 0; j < map[i].length; j++) {
    			sb.append(map[i][j]);
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
    private static void recursion(int x,int y, int idx, int len) {
    	if(idx == 4) {
    		for(int i = 0; i < len; i++) {
    			for(int j = 0; j < len; j++) {
    				map[i+x][j+y] = ' ';
    			}
    		}
    		return;
    	}
    	if(len == 1) {
    		map[x][y] = '*';
    		return;
    	}
    	int num = 0;
    	int nextLen = len / 3;
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			recursion(x + (i * nextLen), y + (j * nextLen), num++,nextLen);
    		}
    	}
    }
}