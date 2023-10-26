import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String fs = br.readLine();
        String ft = br.readLine();

        int lcm = LCM(fs.length(), ft.length());
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        while(s.length() != lcm){
            s.append(fs);
        }
        while(t.length() != lcm){
            t.append(ft);
        }
        bw.write(s.toString().equals(t.toString()) ? "1" : "0");
        bw.flush();
        bw.close();
    }

    private static int LCM(int a, int b) {
        return (a * b) / GCD(a,b);
    }

    private static int GCD(int a, int b) {
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    
}