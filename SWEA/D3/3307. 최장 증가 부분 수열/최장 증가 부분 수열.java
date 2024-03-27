import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
            int[] LIS = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;
            for(int i = 0 ; i <N; i++){
                int value = Integer.parseInt(st.nextToken());
                if(i == 0){
                	LIS[count++] = value;    
                }else{
                    if(LIS[count-1] < value){
                    	LIS[count++] = value;
                    }else if(LIS[0] > value){
                        LIS[0] = value;
                    }else{
                        LIS[binary(0,count-1,LIS,value)] = value;
                    }
                }
            }
            sb.append(String.format("#%d %d\n",tc,count));
		}
        System.out.println(sb);
	}
    private static int binary(int left, int right, int[] LIS, int key){
    	while(left <= right){
        	int mid = (left + right) >> 1;
            if(LIS[mid] < key){
                left = mid + 1;
            }else if(LIS[mid] > key){
            	right = mid - 1;
            }else{
                return mid;
            }
        }
        return left;
    }
}