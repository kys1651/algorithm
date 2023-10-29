import java.util.Scanner;
class Solution
{

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++){
            int n = sc.nextInt();
            StringBuilder password = new StringBuilder(sc.next());
            while(isUnvalid(password)){
            }
            System.out.println("#" + tc + " " + new String(password));
        }
	}
    private static boolean isUnvalid(StringBuilder password){
        for(int i = 1; i < password.length(); i++){
            if(password.charAt(i) == password.charAt(i-1)){
                password.delete(i-1,i+1);
                return true;
            }
        }
        return false;
    }
}