import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> listA = new LinkedList<>();
        LinkedList<Character> listB = new LinkedList<>();

        // Input
        String a = br.readLine();
        String b = br.readLine();
        char[] as = new char[a.length()];
        char[] bs = new char[b.length()];
        int len = a.length();
        for (int i = 0; i < len; i++) {
            as[i] = a.charAt(i);
            bs[i] = b.charAt(i);
        }// Input End
        Arrays.sort(as);
        Arrays.sort(bs);

        int aL = 0, aR = (len + 1) / 2 - 1;
        int bL = (len + 1) / 2, bR = len - 1;
        int l = 0, r = len - 1;
        char[] answer = new char[len];
        int count = 0;
        while(count < len){
            // 구사가
            if(count % 2 == 0){
                if(as[aL] < bs[bR]){
                    answer[l] = as[aL];
                    l++; aL++;
                }else{
                    answer[r] = as[aR];
                    r--; aR--;
                }
            }else{
                if(as[aL] < bs[bR]){
                    answer[l] = bs[bR];
                    l++; bR--;
                }else{
                    answer[r] = bs[bL];
                    r--; bL++;
                }
            }
            count++;
        }
        System.out.println(answer);
    }
}