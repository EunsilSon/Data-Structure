package LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
    String name, email, address, phone;
    int num;

    public Node(int num, String name, String email, String address, String phone) {
        this.num = num;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public String toString() {
        return String.format("[ No: %s | 이름: %s | 이메일: %s | 주소: %s | 연락처: %s ]", num, name, email, address, phone);
    }
}

public class addressBook {
    int num = 0;

    public LinkedList<Node> insert(LinkedList<Node> book) {
        Scanner input = new Scanner(System.in);

        System.out.print("[이름]: ");
        String name = input.nextLine();
        System.out.print("[이메일]: ");
        String email = input.nextLine();
        System.out.print("[주소]: ");
        String address = input.nextLine();
        System.out.print("[연락처]: ");
        String phone = input.nextLine();

        book.add(new Node(++num, name, email, address, phone)); // 사용자의 편리성을 위해 논리적인 순서도 함께 저장함
        System.out.println("[SUCCESS] 새 데이터가 저장 되었습니다.\n");

        return book;
    }

    public String search(LinkedList<Node> book) {
        String result;

        Scanner input = new Scanner(System.in);

        System.out.print("[찾는 데이터의 번호를 입력하세요]: ");
        int searchNum = input.nextInt();

        if(book.isEmpty() && book.size() < searchNum) { // 연결 리스트가 비었거나, 리스트의 크기보다 큰 수를 입력했을 때
            result = "[Wrong] 존재하는 데이터가 없습니다.\n";
        } else if (book.get(searchNum-1) != null) {
            result = book.get(searchNum-1).toString();
        } else {
            result = "[Wrong] 찾는 데이터가 없습니다.\n"; // 찾는 노드가 비어있을 때
        }
        return result;
    }

    public void remove(LinkedList<Node> book) {
        Scanner input = new Scanner(System.in);

        System.out.print("[삭제할 데이터의 번호를 입력하세요]: ");
        int removeNum = input.nextInt();

        if (book.get(removeNum-1) != null) {
            book.remove(removeNum-1);

            for(int i = 0; i < book.size(); i++) {
                book.get(i).setNum(book.get(i).getNum()-1); // 연결 리스트로 구현된 주소록의 논리적인 순서도 바꿔줌
            }
            System.out.println("[Success] 삭제가 완료 되었습니다.");
        } else {
            System.out.println("[Wrong] 삭제할 데이터가 없습니다.\n");
        }
    }

    public void print(LinkedList<Node> book) {
        for(Node n : book) {
            System.out.println(n.toString());
        }
    }

    public static void main(String[] args) {
        addressBook addressbook = new addressBook();
        LinkedList<Node> book = new LinkedList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("[주소록]\n[1]: 새 데이터 저장\n[2]: 데이터 조회\n[3]: 데이터 삭제\n[4]: 데이터 출력\n[-1]: 종료\n");

        boolean b = true;
        while (b) {
            System.out.print("[원하는 옵션을 입력하세요]: ");
            int option = input.nextInt();

            switch (option) {
                case 1: // 저장
                    System.out.println("\n▷새 데이터 저장◁");
                    addressbook.insert(book);
                    break;
                case 2: // 조회
                    System.out.println("\n▷데이터 조회◁");
                    System.out.println(addressbook.search(book));
                    break;
                case 3: // 삭제
                    System.out.println("\n▷데이터 삭제◁");
                    addressbook.remove(book);
                    break;
                case 4: // 출력
                    System.out.println("\n▷데이터 출력◁");
                    addressbook.print(book);
                    break;
                case -1: // 종료
                    System.out.println("[Exit] 주소록이 종료되었습니다.");
                    b = false;
                    break;
                default:
                    System.out.println("[Wrong] 잘못 입력했습니다. 다시 입력하세요.");
                    break;
            }
        }
    }
}