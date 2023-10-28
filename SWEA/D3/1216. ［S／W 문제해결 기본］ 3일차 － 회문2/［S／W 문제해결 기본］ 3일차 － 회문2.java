import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
        final int SIZE = 100;
		for(int tc = 1; tc <= 10; tc++)
		{
            int t = sc.nextInt();
            char[][] map = new char[SIZE][SIZE];
            for(int i = 0; i < SIZE; i++){
                map[i] = sc.next().toCharArray();
            }
            
            int answer = 0;
            boolean check = false;
            for(int len = 0; len <= map.length; len++){
                for(int i = 0; i < map.length ; i++){
                    for(int j = 0; j <= map.length - len; j++){
                        check = true;
                        for(int k = 0; k < len/2; k++){
                            if(map[ i ][ j + k ] != map[ i ][ j + len - k - 1]){
                                check = false; break;
                            }
                        }
                        if(check){
                            answer = Math.max(answer, len);
                        }
                        check = true;
                         for(int k = 0; k < len / 2; k++){
                            if(map[ j + k  ][ i ] != map[ j + len - k - 1][ i ]){
                                check = false; break;
                            }
                        }
                        if(check){
                            answer = Math.max(answer, len);
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
		}
	}
}