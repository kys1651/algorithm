import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int len = numberLen(n);
            char[] nChar = String.valueOf(n).toCharArray();

            int k = 2 * n;
            String result = "impossible";
            while(len == numberLen(k)){
                char[] kChar = String.valueOf(k).toCharArray();
                
                boolean search = true;
                for(int i = 0; i < len; i++){
                    search = false;
                    for(int j = 0; j < len; j++){
                        if(nChar[i] == kChar[j]){
                            kChar[j] = 'y';
                            search = true;
                            break;
                        }
                    }
                    if(!search) break;
                }
                if(search) {
                    result = "possible";
                    break;
                }
                    
                k += n;
            }
            System.out.printf("#%d %s\n",tc,result);
		}
	}
    private static int numberLen(int n){
        int count = 0;
        while(n != 0){
            n /= 10;
            count++;
        }
        return count;
    }
}