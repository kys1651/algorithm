import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            String line = sc.next();
            String result = "";
            HashSet<Integer>[] marks = new HashSet[4];
            for(int i = 0; i <marks.length; i++){
                marks[i] = new HashSet<>();
            }
            int idx = 0;
            for(int i = 0; i < line.length(); i+= 3){
                char mark = line.charAt(i);
                int num = (line.charAt(i+1) - '0') * 10+ line.charAt(i+2) - '0';
                switch (mark){
                case 'S':
	                idx = 0;
    	            break;
                case 'D':
                    idx = 1;
                    break;
                case 'H':
	                idx = 2;
    	            break;
                case 'C':
        	        idx = 3; 
            	    break;
                default:
                	break;
            	}
                if(marks[idx].contains(num)){
                    result = "ERROR";
                    break;
                }
                marks[idx].add(num);
        	}
            System.out.print("#" + tc + " ");
            if(!result.equals("ERROR")){
                for(int i = 0; i < 4; i++){
                    System.out.print(13 - marks[i].size() + " ");
                }
                System.out.println();
            }
            else{
                System.out.println(result);
            }
		}
	}
}