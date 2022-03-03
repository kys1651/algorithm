package com.company;

import java.util.Scanner;

public class Main {
    //세 값의 최솟값
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

        System.out.println("세 정수의 최솟값을 구합니다.");
        System.out.print("a의 값: "); int a = sc.nextInt();
        System.out.print("b의 값: "); int b = sc.nextInt();
        System.out.print("c의 값: "); int c = sc.nextInt();

        int min = (a > b)? b : a;
        min = (min>c)? c : min;

        System.out.println("최댓값은 " + min + "입니다.");
    }
}
