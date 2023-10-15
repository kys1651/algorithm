import java.util.Scanner;
import java.io.FileInputStream;

class Solution2072 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int result = 0;
            for(int i = 0; i < 10; i++){
                int n = sc.nextInt();
                if(n % 2 != 0)
                    result += n;
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}