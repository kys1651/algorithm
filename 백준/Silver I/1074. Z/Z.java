import java.util.*;
import java.io.*;

public class Main{
    static int r,c,n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(z(r,c,n));
    }
    private static int z(int x, int y, int len){
    	if(len == 0) {
    		return 0;
    	}
    	
    	int nextLen = len / 2;
    	if(x < nextLen && y < nextLen) {
    		return z(x,y,nextLen);
    	}else if(x < nextLen && y >= nextLen) {
    		return nextLen * nextLen + z(x,y-nextLen,nextLen);
    	}else if(x>=nextLen && y < nextLen) {
    		return nextLen * nextLen * 2 + z(x-nextLen,y,nextLen);
    	}else {
    		return nextLen * nextLen * 3 + z(x-nextLen, y - nextLen, nextLen);
    	}
    }
}