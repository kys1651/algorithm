import java.io.IOException;
import java.util.Scanner;

class Solution{ 
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int n = sc.nextInt();
            int b = sc.nextInt();
            int e = sc.nextInt();
            int result = 0;
            for(int i = 0; i < n; i++){
                int timer = sc.nextInt();
                for(int j = b - e; j <= b+e; j++){
                    if(j % timer == 0){
                        result++;
                        break;
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
