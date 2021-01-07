package ArrayList;

public class Polynomial1 {
    public int size = 0; // ArrayList에 존재하는 데이터 수
    public Object[] elementData = new Object[100];

    // 데이터 삽입
    public boolean add(Object element) {
        elementData[size] = element;
        size++;

        return true;
    }

    // 데이터 추출
    public int get(int index) {
        return (int) elementData[index];
    }

    // ArrayList 크기
    public int size() {
        return size;
    }

    // ArrayList에 저장된 다항식을 문자열로 출력하기
    public String toString() {
        String str = "[";

        for(int i = size-1; i >= 0; i--) {
            if(!(elementData[i].equals(0))) {
                str += elementData[i] + "x^" + i;

                if (i > 0) {
                    str += ", ";
                }
            }
        }
        return str +"]";
    }

    public static Polynomial1 addPolynomial(Polynomial1 polyA, Polynomial1 polyB) {

        int minPoly = polyA.size() < polyB.size() ? polyA.size() : polyB.size();
        Polynomial1 polyC = new Polynomial1();

        int i;
        for(i = 0; i < minPoly; i++) {
            polyC.add(polyA.get(i) + polyB.get(i));
        }

        if(polyA.size() > minPoly) {
            polyC.add(polyA.get(i));
        } else {
            polyC.add(polyB.get(i));
        }

        return polyC;
    }

    public static void main(String[] args) {
        Polynomial1 polyA = new Polynomial1();
        polyA.add(7);
        polyA.add(0);
        polyA.add(0);
        polyA.add(6);
        polyA.add(5);
        System.out.println("다항식 A: " + polyA.toString());

        Polynomial1 polyB = new Polynomial1();
        polyB.add(0);
        polyB.add(3);
        polyB.add(-7);
        polyB.add(2);
        System.out.println("다항식 B: " + polyB.toString());

        System.out.println("다항식 A+B: " + addPolynomial(polyA, polyB));
    }

}
