import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            HashSet<String> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < a; i++){
                set.add(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            int ret = 0;
            for(int i = 0; i < b; i++){
                if(set.contains(st.nextToken())) ret++;
            }
		
            sb.append("#").append(tc).append(' ').append(ret).append('\n');
		}
        System.out.println(sb);
	}
}