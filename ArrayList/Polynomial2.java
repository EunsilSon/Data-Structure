package ArrayList;

import java.util.ArrayList;

class Node {
    int coef; // 다항식 항의 계수
    int expo; // 다항식 항의 지수

    public Node(int coef, int expo) {
        this.coef = coef;
        this.expo = expo;
    }

    public String toString() {
        return String.format("%dx^%d", coef, expo);
    }
}

public class Polynomial2 {

    public static ArrayList<Node> addPolynomial(ArrayList<Node> polyA, ArrayList<Node> polyB) {

        ArrayList<Node> polyC = new ArrayList<>();

        int i = 0, j = 0;

        while(i < polyA.size() && j < polyB.size()) {

            // polyA 의 지수가 polyB 의 지수보다 큰 경우
            if(polyA.get(i).expo > polyB.get(j).expo) {
                polyC.add(new Node(polyA.get(i).coef, polyA.get(i).expo));
                ++i;
            }
            // polyB 의 지수가 polyA 의 지수보다 큰 경우
            else if (polyA.get(i).expo < polyB.get(j).expo) {
                polyC.add(new Node(polyB.get(j).coef, polyB.get(j).expo));
                ++j;
            }
            // polyA 의 지수와 polyB의 지수가 같은 경우
            else {
                polyC.add(new Node(polyA.get(i).coef + polyB.get(j).coef, polyA.get(i).expo));
                ++i;
                ++j;
            }
        }

        // polyA에 항이 남았을 때
        while(i < polyA.size()) {
            polyC.add(new Node(polyA.get(i).coef, polyA.get(i).expo));
            ++i;
        }

        // polyB에 항이 남았을 때
        while(i < polyB.size()) {
            polyC.add(new Node(polyB.get(j).coef, polyB.get(j).expo));
            ++j;
        }

        return polyC;
    }

    public static void main(String[] args) {
        ArrayList<Node> polyA = new ArrayList<>();
        polyA.add(new Node(5,4));
        polyA.add(new Node(6,3));
        polyA.add(new Node(7,0));
        System.out.println("다항식 A: " + polyA);

        ArrayList<Node> polyB = new ArrayList<>();
        polyB.add(new Node(2,3));
        polyB.add(new Node(-7,2));
        polyB.add(new Node(3,1));
        System.out.println("다항식 B: " + polyB);

        ArrayList<Node> addPoly = addPolynomial(polyA, polyB);
        System.out.print("다항식 A+B: " + addPoly);
    }
}