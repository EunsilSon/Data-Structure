package DataStructure;/*
 문자열을 전달받아 회문(palindrome) 인지 체크하는 함수 작성
 형식 : static boolean isPalindrome(String str) {...}

 예) isPalindrome("eye") == true, isPalindrome("noon") == true
 */

import java.util.*;

public class Factorial_Q1 {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("문자 3개 이상의 문자열을 입력하세요: ");
            String str = sc.nextLine();

            if (str.length() >= 3) {
                int front = 0;
                int behind = str.length() - 1;

                System.out.println(isPalindrome(str, front, behind));
                break; // 1회성 확인 프로그램. 일정 횟수 or 사용자가 원하는 횟수 만큼 반복하도록 수정 가능

            } else {
                System.out.println("문자열이 너무 짧습니다. 다시 입력하세요.\n");
            }
        }
    }

    static String isPalindrome(String str, int front, int behind) {
        if (front < behind) {
            if (str.charAt(front) != str.charAt(behind)) {
                return "Not Palindrome";
            } else {
                front += 1;
                behind -= 1;
                isPalindrome(str, front, behind);
            }
        }
        return "Palindrome";
    }
}