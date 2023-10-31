import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        String noHole = "CEFGHIJKLMNSTUVWXYZ";
        String oneHole = "ADOPQR";
		for(int tc= 1; tc <= T; tc++)
		{
	        String a = sc.next();
            String b = sc.next();
            String result = "SAME";
            if(a.length() != b.length()){
                result = "DIFF";
            }else{
                for(int i = 0; i < a.length(); i++){
                    String posA = String.valueOf(a.charAt(i));
                    String posB = String.valueOf(b.charAt(i));
                    if(posA.equals("B") && posB.equals("B")){
                   }else if(noHole.contains(posA) && noHole.contains(posB)){
                   }else if(oneHole.contains(posA) && oneHole.contains(posB)){
                   }else{
                       	result = "DIFF";
                       	break;
                    }
               }
           }
            System.out.println("#" + tc + " " + result);
        }
	}
}