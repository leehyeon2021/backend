package 종합.예제3;

import java.util.Scanner;

public class BoardService3 {
    public static void main(String[] args) {
        // [1] Board 클래스 선언
        // [2] Board 객체 여러 개 저장 = 배열
        Board[] boards = new Board[100];  // 총 100 객체 저장 가능
        for( ; ; ) {
            // [3] 출력
            System.out.println("======= My community =======");
            System.out.println("1. 게시물 쓰기  2. 게시물 출력");
            System.out.println("============================");
            System.out.print("선택> ");
            // [4] 입력 개체
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            if(ch == 1){ // [5] 조건문. 입력받은 값이 1이면 입력기능
                scan.nextLine();
                System.out.print("내용: "); String content = scan.nextLine();
                System.out.print("작성자: "); String name = scan.nextLine();
                Board 생성한게시물 = new Board(); // [6] 객체 만들기 (생성한게시물 은 지역변수라서 사라짐. 변수가 사라지면 객체 자연삭제. 아무도 안 보면 사라짐
                생성한게시물.내용 = content;     생성한게시물.작성자 = name;  // [7] 생성한 객체에 입력받은 값
                // [8] 생성한 객체를 배열에 저장. (push가 없으므로 직접 넣음)
                boolean check = true; // true: 저장성공, false: 저장실패
                for(int index = 0; index < boards.length; index++){
                    if(boards[index] == null){  // 비어있으면
                        boards[index] = 생성한게시물; // '생성한게시물'은 함수 끝나고 사라지겠지만,  객체를 비어있는 index번째에 넣으면서 삭제 방지. GC의 자동 삭제
                        check = true;
                        break;
                    }
                } // for end
                if(check == true){System.out.println("[안내] 글쓰기 성공");}
                else{System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");}
            } // if(ch == 1) end
            else if(ch == 2){ // 입력받은 값이 2이면 출력기능
                for(int i = 0; i <= boards.length ; i++){
                    Board 게시물 = boards[i]; // index번째 요소가 비어있으면
                    if(게시물!=null){ // 해당 게시물이 비어있지 않으면
                        System.out.printf("======게시물 목록======\n작성자: %s\n내용: %s\n====================\n", 게시물.작성자, 게시물.내용);
                    } // if end
                } // for end
            } // else if(ch == 2) end
        } // for end
    }
}
