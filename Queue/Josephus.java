package Queue;

import java.util.*;

public class Josephus {

    public static void killThirdPerson(int people) {
        Queue<Integer> circleQ = new LinkedList<>();

        // 원형 큐에 people 만큼 데이터 삽입하기
        for(int i = 1; i <= people; i++)
            circleQ.add(i);

        // 원형 큐의 (데이터 개수 > 2) 만큼 반복
        int count = 0;

        while(circleQ.size() > 2) {
            ++count;
            if(count == 3) {
                circleQ.remove();
                count = 0;
            } else {
                circleQ.add(circleQ.remove()); // 꺼내서 원형 큐의 뒤로 다시 추가
            }
        }
        System.out.println(circleQ.toString());
    }

    public static void main(String[] args) {
        // n명의 사람 입력 받기
        Scanner input = new Scanner(System.in);
        System.out.print("인원을 입력하세요: ");
        int people = input.nextInt();

        killThirdPerson(people);
    }
}