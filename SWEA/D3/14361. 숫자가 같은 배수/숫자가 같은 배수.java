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
            int num = sc.nextInt();
			String origin = String.valueOf(num);
            int i = 2;
            String mul = String.valueOf(num * i);
            boolean check = false;
            
            while(mul.length() == origin.length()){
                check = true;
                
                for(int idx = 0; idx < mul.length(); idx++){
                    String ch = String.valueOf(mul.charAt(idx));
                    if(!origin.contains(ch)){
                        check = false;
                        break;
                    }
                }
                
                if(check){
                    break;
                }else{
                    i++;
                    mul = String.valueOf(num * i);
                }
            }
            System.out.println("#" + tc + " " + (check ? "possible" : "impossible"));
		}
	}
}