package 종합.예제5;

import java.util.Scanner;

public class BoardService {
    public static void main(String[] args) {
        // [1] Controller 객체 생략: static이라서 객체 생성 없이 기능 호출 가능
        // [2]
        for( ; ; ){
            System.out.println("========My community========");
            System.out.println("1. 게시물 쓰기  |  2. 게시물 출력");
            System.out.println("===============================");
            System.out.print("선택> ");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            if(ch == 1){
                scan.nextLine();
                System.out.print("내용:"); String content = scan.nextLine();
                System.out.print("작성자:"); String writer = scan.nextLine();
                // BoardController.doPost() : static메소드( 클래스명.매소드명() )
                    // vs. bc.doPost() : 일반메소드( 객체명.메소드명() )
                boolean result = BoardController.doPost( content , writer);
                    // 함수 호출 후 반환(결과)에 따른 흐름제어를 하기 위해 boolean result 변수에 결과값 저장 (아래처럼 또 쓸 거니까 저장한다는 뜻)
                if(result){System.out.println("[안내]");}
                else{System.out.println("[경고]");}
            }//if end
            else if (ch==2) {
                Board[] boards = BoardController.doGet();
                for( Board board : boards){
                    if(board!=null) {
                        // board.writer는 직접접근(안 됨) vs. board.getWriter()는 간접접근
                        System.out.printf("작성자: %s , 내용: %s\n", board.getWriter(), board.getContent());
                    }
                }
            }
        }//for end
    }
}
