class Solution {
    public String solution(int age) {
        String answer;
        char[] arr = Integer.toString(age).toCharArray();
        for(int i=0;i <arr.length;i++)
            arr[i] += 49;
        
        answer = new String(arr);
        return answer;
    }
}