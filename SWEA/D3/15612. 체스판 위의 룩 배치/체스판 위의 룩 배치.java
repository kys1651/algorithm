import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        boolean arr[][];
        String result;
		int count;
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            arr = new boolean[2][8];
            count = 0;
            result = "yes";
			for(int i = 0; i < 8; i++){
                String line = sc.next();
                
                for(int j = 0; j < line.length(); j++){
                    if(line.charAt(j) == 'O'){
                        if(arr[0][i] || arr[1][j]){
                            result = "no";
                            break;
                        }
                        arr[0][i] = arr[1][j] = true;
                        count++;
                    }
                }
            }
            
            if(count != 8){
                result = "no";
            }
            
            System.out.println("#" + tc + " " + result);
		}
	}
}