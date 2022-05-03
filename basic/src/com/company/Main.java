package com.company;

import java.util.Scanner;

public class Main {
    static String Ethernet_type(String str){
        //이더넷의 물리주소 7번째 비트를 1로 바꾸고 FFFE를 추가를 위한 함수

        String array_split[] = str.split("-");//-를 기준으로 문자열을 잘라냄
        String result = "";//첫번째로 잘라낸 문자열을 가져옴
        String tmp = "";
        String bin_array[] = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        //이진수를 담아놓은 배열
        String hex_array[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        //16진수를 담아놓은 배열

        for(int i = 0 ; i < array_split[0].length();i++){//16진수를 2진수로 변환
            for(int j = 0; j < 16; j++){
                if(Character.toString(array_split[0].charAt(i)).equals(hex_array[j])){
                    tmp += bin_array[j];//16진수배열과 같은 내용 발견시 이진수로 변환하여 임시변수 tmp에 삽입
                }
            }
        }

        StringBuilder sb = new StringBuilder(tmp);//문자열 분리를 위한 스트링 빌더 생성
        sb.setCharAt(6,'1');            //2진수로 치환한 result의 7번째 index를 1로 변경
        tmp = sb.toString();                      //다시 16진수 변환을 위해 tmp에 넣어둠
        String a = tmp.substring(0,4);            //앞 2진수 4비트를 a에 넣음
        String b = tmp.substring(4);              //뒤 2진수 4비트를 b에 넣음

        for(int j = 0; j <16; j++){
            if(a.equals(bin_array[j]))          //앞 4비트 a를 16진수로 변환,result에 추가
                result += hex_array[j];
        }

        for(int j = 0; j <16; j++){
            if(b.equals(bin_array[j]))          //뒤 4비트 b를 16진수로 변환,result에 추가
                result += hex_array[j];
        }

        result += array_split[1] + array_split[2] + "FFFE" + array_split[3]
                +array_split[4] + array_split[5];
        //result뒤에 -를 제외한 숫자들을 이어 붙히고 FFFE 또한 삽입 후 반환
        return result;
    }
    static String colon(String str){
        //콜론이 없는 주소 문자열에 콜론을 삽입하는 함수

        int count = 0;

        StringBuffer sb = new StringBuffer();//콜론과 문자열을 추가하기 위한 스트링 빌더

        for(int i = 0 ; i < str.length(); i++){//str길이만큼의 for문
            //카운트가 4(숫자를 4개 추가)되면 ':' 추가
            //마지막 부분에 ':'를 추가하지 않기 위해 str.length()-1일땐 추가 x
            if(count==4&&i!=str.length()-1){
                count = 0;  // 카운트를 다시 0으로 변경
                sb.append(':');

            }
            count++;//문자 append마다 count를 증가
            sb.append(str.charAt(i));
        }
        // 문자열 마지막에 /128을 추가하여 완성시킴
        return sb.toString() + "/128";
    }
    static String split_colon(String str){
        //입력받은 문자열의 ':'을 제거하는 함수
        String result ="";
        String array[] = str.split(":");
        //  입력 받은 str을 : 단위로 분리하여 배열에 넣음1
        for(int i = 0; i < array.length;i++){// array배열의 크기만큼
            result += array[i];
        }
        return result;//:을 제외한 문자열 리턴
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5 ; i++) {   //5번 반복을 위한 for문
            System.out.print("> Input organization block: ");
            String organization = sc.nextLine();
            //기관 블록(글로벌 유니캐스트 접두사) 입력받기.
            String organization_split[] = organization.split("/");
            //뒤에 있는 prefix길이를 제거하기 위해 "/"를  기준으로 분리함
            System.out.print("> Input subnet identifier: ");
            String subnet = sc.nextLine();
            //서브넷 식별자 입력받기.
            System.out.print("> Input Ethernet address: ");
            String Ethernet = sc.nextLine();
            //이더넷 물리주소 입력 받기.
            String result = colon(split_colon(organization_split[0]) + split_colon(subnet) + Ethernet_type(Ethernet));
            //이더넷 주소는 변환을 위해 함수 호출
            System.out.println("> Mapped IPv6 address: " + result +"\n");
        }

    }
}
