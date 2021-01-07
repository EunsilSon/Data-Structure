package LinkedList;

import java.util.LinkedList;

class polyNode {
    int coef;
    int expo;

    public polyNode(int coef, int expo) {
        this.coef = coef; // 계수
        this.expo = expo; // 지수
    }

    public String toString() {
        return String.format("%dx^%d", coef, expo);
    }
}

public class Polynomial3 {
    public static LinkedList<polyNode> addPolynomial(LinkedList<polyNode> polyA, LinkedList<polyNode> polyB) {
        LinkedList<polyNode> polyC = new LinkedList<>();

        int i = 0, j = 0;

        while(i < polyA.size() && j < polyB.size()) {
            // polyA의 지수가 더 클 때
            if(polyA.get(i).expo > polyB.get(j).expo) {
                polyC.add(new polyNode(polyA.get(i).coef, polyA.get(i).expo));
                ++i;
            }
            // polyB의 지수가 더 클 때
            else if(polyA.get(i).expo < polyB.get(j).expo) {
                polyC.add(new polyNode(polyB.get(j).coef, polyB.get(j).expo));
                ++j;
            }
            // 지수가 같을 때
            else {
                polyC.add(new polyNode(polyA.get(i).coef + polyB.get(j).coef, polyA.get(i).expo));
                ++i;
                ++j;
            }
        }

        // polyA의 항이 남았을 때
        while(i < polyA.size()) {
            polyC.add(new polyNode(polyA.get(i).coef, polyA.get(i).expo));
            ++i;
        }
        // polyB의 항이 남았을 때
        while(j < polyB.size()) {
            polyC.add(new polyNode(polyB.get(i).coef, polyB.get(i).expo));
            ++j;
        }

        return polyC;
    }

    public static void main(String[] args) {
        LinkedList<polyNode> polyA = new LinkedList<>();
        polyA.add(new polyNode(5, 4));
        polyA.add(new polyNode(6, 3));
        polyA.add(new polyNode(7, 0));
        System.out.println("다항식 A: " + polyA);

        LinkedList<polyNode> polyB = new LinkedList<>();
        polyB.add(new polyNode(2, 3));
        polyB.add(new polyNode(-7, 2));
        polyB.add(new polyNode(3, 1));
        System.out.println("다항식 B: " + polyB);

        System.out.println("다항식 A+B: " + addPolynomial(polyA, polyB));
    }
}