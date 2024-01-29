import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++){
			String input = br.readLine();
            int result = 0;
            char prev = '0';
            for(char ch : input.toCharArray()){
            	if(prev != ch){
                    result++;
                    prev = ch;
                }
            }
            sb.append(String.format("#%d %d\n",tc,result));
        }
        System.out.println(sb);
	}
}
