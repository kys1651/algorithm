import java.util.Scanner;

class Main{ 
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[2000001];
        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(prime.length); i++){
            if(prime[i]) continue;
            for(int j = i * 2; j < prime.length; j += i){
                prime[j] = true;
            }
        }
        int n = sc.nextInt();
        int result = 0;
        for(int i = n; i < prime.length; i++){
            if(prime[i]) continue;
            String num = String.valueOf(i);
            result = i;
            for(int j = 0; j < num.length() / 2; j++){
                if(num.charAt(j) != num.charAt(num.length() - j - 1)){
                    result = 0;
                    break;
                }
            }
            if(result != 0){
                break;
            }
        }
        System.out.println(result);
    }
}
