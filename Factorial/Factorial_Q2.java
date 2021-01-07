package DataStructure;/*
 정수를 전달받아 2진수 형식의 정수로 변환하는 함수 작성
 형식: int toBinary(int dec)

 예) toBinary(10) == 1010, toBinary(127) == 1111111
 */

import java.util.*;

public class Factorial_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("10진수를 입력하시오: ");
        int dec = sc.nextInt();

        Factorial_Q2 f = new Factorial_Q2();
        f.toBinary(dec);
    }

    public void toBinary(int dec) {
        if (dec > 0) {
            toBinary(dec / 2);
            System.out.print(dec % 2);
        }
    }
}