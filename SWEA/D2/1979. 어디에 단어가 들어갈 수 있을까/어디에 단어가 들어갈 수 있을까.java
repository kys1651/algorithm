import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int map[][];
		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
            int K = sc.nextInt();
            map = new int[N][N];
            
            int result = 0;
            for(int i = 0; i < N; i++){
            	for(int j = 0; j < N; j++){
                	map[i][j] = sc.nextInt();
                }
            }
            
            // 가로 
            for(int i = 0; i < N; i++){
                int count = 0;
            	for(int j = 0; j < N; j++){
                    // 흰색일 때
                    if(map[i][j] == 1){
                        count++;
                    }
                    //검정색일 때
                    else{
                        if(count == K){
                            result++;
                        }
                        count = 0;
                    }
                }
                if(count == K){
                    result++;
                }
            }
            
            // 세로일 때
            for(int i = 0; i < N ; i++){
                int count = 0;
                for(int j = 0; j < N; j++){
					// 흰색일 때
                    if(map[j][i] == 1){
                        count++;
                    }
                    // 검정색일 때
                    else{
                        if( count == K){
                            result++;
                        }
                        count = 0;
                    }
                }
                if(count == K){
                    result++;
                }
            }
            
            System.out.printf("#%d %d\n",tc,result);
		}
	}
}