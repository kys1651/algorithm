import java.io.IOException;
import java.util.Scanner;

class Solution{ 
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            long a = sc.nextInt();
            long b = sc.nextInt();
            System.out.println("#" + tc + " " + (a * a) / (b * b));
        }
    }
}
