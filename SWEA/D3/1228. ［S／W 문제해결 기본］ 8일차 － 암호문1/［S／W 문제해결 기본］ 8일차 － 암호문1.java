import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++)
		{
            int n = sc.nextInt();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < n; i++){
                list.add(sc.nextInt());	
            }
            int command = sc.nextInt();
            for(int i = 0; i < command; i++){
                sc.next();
                int pos = sc.nextInt();
                int count = sc.nextInt();
                for(int j =0; j < count; j++){
                    list.add(pos+j,sc.nextInt());
                }
            }
                
            System.out.print("#" + tc+ " ");
            for(int i = 0; i < 10; i++){
                System.out.print(list.get(i)+ " " );
            }
            System.out.println();
		}
	}
}