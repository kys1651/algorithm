
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);

        int[] a = new int[n];
        int[] b = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();

        String[] arr = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++){
            a[i] = Integer.parseInt(arr[i]);
            b[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(a);
        int idx = 0;

        for(int num:a){
            if(!map.containsKey(num)){
                map.put(num,idx);
                idx++;
            }
        }
        for(int key:b){
            bw.write(map.get(key)+" ");
        }
        bw.flush();
        bw.close();
    }
}

