import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        boolean[] prime = new boolean[1000001];
        prime[1] = true;
        for(int i = 2; i <= Math.sqrt(prime.length); i++){
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i){
                prime[j] = true;
            }
        }
        for(int i = 2; i < prime.length; i++){
            if(prime[i]) continue;
            System.out.print(i + " " );
        }
	}
}