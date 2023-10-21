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
            String a = sc.next();
            String b = sc.next();
            int lcm = lcm(a.length(),b.length());
            StringBuilder result1 = new StringBuilder();
            StringBuilder result2 = new StringBuilder();
			while(result1.length() != lcm){
                result1.append(a);
            }
            while(result2.length() != lcm){
                result2.append(b);
            }
            System.out.print("#" + tc +" ");
            if(result1.toString().equals(result2.toString())){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
		}
	}
    
    private static int lcm(int a,int b){
        return a * b / gcd(a,b);
    }
    
    private static int gcd(int a, int b){
        while(b!=0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
    
