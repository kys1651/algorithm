import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n;
        while(!(n = br.readLine()).equals("0")){
            String result = "yes";
            for(int i = 0; i < n.length()/2; i++){
                if(n.charAt(i)!=n.charAt(n.length() - i - 1)){
                    result = "no";
                    break;
                }
            }
            System.out.println(result);
        }
	}
}