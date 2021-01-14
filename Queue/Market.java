/*
* 대기 큐와 서버는 각 1개이며, 고객 도착과 서비스는 독립 수행된다.
* 고객 도착시 대기 큐에 입력하고, 도착 순서대로 손님에게 서비스를 수행한다.
* 손님 별 서비스 시간과 평균 대기 시간을 출력하시오.
*
* 입력: 고객, 도착 시간, 서비스 소요 시간
* 출력: 1) 고객 별 도착 시간, 서비스 시작 시간, 서비스 완료 시간
        2) 평균 대기 시간
*/

import java.util.*;

class CustomerQueue {

    private class Node {

        private String customer; // 고객 성함
        private int arrivalTime, takeTime; // 도착 시간, 서비스 소요 시간
        int startTime, endTime; // 서비스 시작 시간, 종료 시간

        Node(String customer, int arrivalTime, int takeTime) {
            this.customer = customer;
            this.arrivalTime = arrivalTime;
            this.takeTime = takeTime;
        }

        public void setStartTime(int time) { this.startTime = time; }

        public void setEndTime(int time) { this.endTime = time; }

        public int getStartTime() { return this.startTime; }

        public int getEndTime() { return this.endTime; }

        public int getTakeTime() { return this.takeTime; }

        public int getArrivalTime() { return this.arrivalTime; }

        public String toString() {
            return String.format("[고객 명: %s | 도착 시각:  %d | 시작 시각: %d | 완료 시각: %d]", this.customer, this.arrivalTime, this.startTime, this.endTime);
        }
    }

    Queue<Node> q = new LinkedList<>();
    ArrayList<Integer> waiting = new ArrayList<>(); // 고객 대기 시간 리스트

    int endTime, waitTime; // 서비스 종료 시간, 대기 시간
    int frontCustomer; // 앞 고객의 서비스 종료 시간(== 다음 고객의 서비스 시작 시간)
    boolean sequence = true; // 첫 고객 판별

    public CustomerQueue() { }

    // 대기열에 고객 정보 삽입
    public void insert(String customer, int arrivalTime, int takeTime) {
        q.add(new Node(customer, arrivalTime, takeTime));
    }

    // 서비스
    public void service() {
        System.out.println("\n[서비스 현황]");

        while (!q.isEmpty()) {

            // 서비스 시작 시간
            if (sequence) {
                q.peek().setStartTime(q.peek().getArrivalTime()); // 첫 손님은 도착 시간 == 시작 시간
                sequence = false;
            } else {
                q.peek().setStartTime(frontCustomer);
            }

            // 서비스 완료 시간
            endTime = q.peek().getStartTime() + q.peek().getTakeTime();
            q.peek().setEndTime(endTime);

            frontCustomer = q.peek().getEndTime(); // 뒷 고객의 서비스 시작을 위해 현재 고객의 종료 시간 저장

            // 대기 시간
            waitTime = q.peek().getStartTime() - q.peek().getArrivalTime();
            waiting.add(waitTime);

            // 서비스 완료된 고객의 정보 출력 + 삭제
            System.out.println(q.remove());

        }
        System.out.println("[평균 대기 시간: " + averageWaiting(waiting) + "시간]");
    }

    // 평균 대기 시간
    public int averageWaiting(ArrayList<Integer> arr) {
        int average = 0;

        for(int i = 0; i < arr.size(); i++)
            average += arr.get(i);

        return average / arr.size();
    }
}

public class Market {
    public static void main(String[] args) {
        boolean run = true; // 프로그램 가동
        CustomerQueue customerQ = new CustomerQueue();
        Scanner input = new Scanner(System.in);

        while(run) {
            System.out.println("\n[1]: 고객 추가\n[2]: 서비스 현황\n[0]: 종료");
            System.out.print("원하는 옵션을 선택하세요: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n[새 고객 입력]");
                    System.out.print("고객 명: ");
                    input.nextLine(); //개행 문자 (엔터) 제거 용
                    String customer = input.nextLine();

                    System.out.print("도착 시간: ");
                    int arrivalTime = input.nextInt();

                    System.out.print("서비스 소요 시간: ");
                    int takeTime = input.nextInt();

                    customerQ.insert(customer, arrivalTime, takeTime); // 고객 정보 입력
                    break;
                case 2:
                    customerQ.service(); // 고객 정보 입력 완료 시 서비스 시작
                    break;
                case 0:
                    System.out.println("\n종료 되었습니다.");
                    run = false;
                    break;
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력하세요.\n");
                    break;
            }
        }
    }
}
