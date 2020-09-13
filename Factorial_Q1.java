package DataStructure;/*
 문자열을 전달받아 회문(palindrome) 인지 체크하는 함수 작성
 형식 : boolean isPalindrome(String str) {...}

 예) isPalindrome("eye") == true, isPalindrome("noon") == true
 */

import java.util.*;

public class Factorial_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력하시오 : ");
        String str = sc.nextLine();

        Factorial_Q1 f = new Factorial_Q1();
        System.out.println(f.isPalindrome(str));
    }

    public boolean isPalindrome(String str) {
        int front = 0;
        int behind = str.length() - 1;

        while (front < behind) { // 재귀함수 내 반복문 사용은 비효율적 -> 재귀함수 자체가 반복을 위한 것이기 때문
            if (str.charAt(front) != str.charAt(behind)) {
                return false;
            } else {
                front += 1;
                behind -= 1;
            }
        }
        return true;
    }
}