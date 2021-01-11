package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Binary {
    public static String toBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        String result = "";

        while(num >= 1) {
            stack.push(num % 2);
            num /= 2;
        }

        while(!stack.empty())
            result += stack.pop();

        return "2진수: " + result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("10진수: ");
        System.out.println(toBinary(input.nextInt()));
    }
}
