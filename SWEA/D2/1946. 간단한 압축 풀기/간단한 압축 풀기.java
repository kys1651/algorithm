import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
        int T = sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{
            sb = new StringBuilder();
            int N = sc.nextInt();
            int count = 0;
            for(int i = 0; i < N; i++){
                String ch = sc.next();
                int k = sc.nextInt();
                while(k-- > 0){
                    sb.append(ch);
                    count++;
                    if(count == 10){
                        sb.append("\n");
                        count = 0;
                    }
                }
            }
            System.out.println("#" + tc);
            System.out.println(sb.toString());
		}
	}
}