import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer((br.readLine()));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] basket = new int[n+1];
        int[] newbasket = new int[n + 1];
        for(int i = 1 ; i <= n; i++){
            basket[i] = i;
            newbasket[i] = i;
        }

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int middle = Integer.parseInt(st.nextToken());

            int begin = start;
            for(int j = 0; j < end-start+1; j++){
                if(middle+j <= end){
                    newbasket[start+j] = basket[middle+j];
                }else{
                    newbasket[start+j] = basket[begin++];
                }
            }

            for(int j = 1 ; j <= n; j++){
                basket[j] = newbasket[j];
            }
        }

        for(int i = 1; i <= n; i++)
            System.out.print(basket[i]+ " ");
    }
}