import java.util.Scanner;

class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       
        int[] peoples = new int[n];
        for(int i = 0; i < n;i++){
            peoples[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        long result = n;
        for(int i = 0; i < peoples.length; i++){
            peoples[i] -= a;
            if(peoples[i] > 0){
                int tmp1 = peoples[i] / b;
                int tmp2 = peoples[i] % b == 0? 0 : 1;
                result += (tmp1 + tmp2);
            }
        }
        System.out.println(result);
    }
}