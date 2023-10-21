import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Set<Integer> set;
        
        boolean result;
        int arr[];
		int count = 0;
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            set = new HashSet<>();
            arr = new int[9];
            count = 0;
            result = true;
			for(int i = 1; i <= 8; i++){
                String line = sc.next();
                
                for(int j = 1; j <= 8; j++){
                    char ch = line.charAt(j-1);
                    if(ch == 'O'){
                        if(arr[j] != 0){
                            result = false;
                        }
                        arr[j] = i;
                        count++;
                    }
                }
            }
            
            for(int i = 1; i <= 8; i++){
                int n = arr[i];
                if(set.contains(n) || n == 0){
                    result = false;
                }
                set.add(n);
            }
            
            
            System.out.println("#" + tc + " " + (result?"yes":"no"));
		}
	}
}