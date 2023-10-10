class Solution
{
    public int solution(int n, int a, int b)
    {
        int count = 1;
        while(true){
            if(a % 2 != 0) a++;
            if(b % 2 != 0) b++;
            
            if(a == b)
                break;
            
            a /= 2;
            b /= 2;
            count++;
        }
        return count;
    }
}