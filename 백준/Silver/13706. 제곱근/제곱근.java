import java.io.*;
import java.math.BigInteger;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger bi = new BigInteger(br.readLine());
        bw.write(bi.sqrt().toString(0) + "\n");
        bw.flush();
        bw.close();
    }
}