package 종합.예제7.view;

import 종합.예제7.controller.BoardController;
import 종합.예제7.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){return instance;}


    private BoardController bc = BoardController.getInstance();

    private Scanner scan = new Scanner(System.in);

    public void index(){
        for(;;){
            try {
                System.out.println("======================== My community ========================");
                System.out.println("1. 게시물 쓰기 | 2. 게시물 출력 |  3. 게시물 수정 | 4. 게시물 삭제");
                System.out.println("===============================================================");
                System.out.print("선택> ");                int ch = scan.nextInt();
                if (ch == 1) { write(); }
                else if (ch == 2) {findAll();}
                else if (ch == 3) {update();}
                else if (ch == 4) { delete(); }
                else {
                    System.out.println("[경고] 없는 기능 번호입니다.");
                }
            }catch (InputMismatchException e){
                System.out.println("[경고] 잘못된 입력 방식입니다. [재입력]");
                scan = new Scanner(System.in); // 입력 객체 초기화 (잘못된 입력값 제거)
            }catch (Exception e){ // Exception은 예외 중 슈퍼클래스로 모든 예외 처리가 가능하다.
                System.out.println("[시스템오류] 관리자에게 문의하세요.");
            }
        }//for end
    }//index end

    // 1. 게시물 등록 view
    public void write(){
        scan.nextLine();
        System.out.print("내용: "); String bcount = scan.nextLine();
        System.out.print("작성자: "); String bwriter = scan.next();
        boolean result = bc.write(bcount , bwriter);
        if( result ){ System.out.println("[안내] 게시물 등록 완료");}
        else{System.out.println("[경고] 게시물 등록 실패");}
    }

    // 2. 게시물 전체 조회 view
    public void findAll(){
        ArrayList<BoardDto> boards = bc.findAll();
        for( BoardDto board : boards){
            System.out.printf("번호: %d , 작성일: %s , 작성자: %s ,\n내용: %s\n", board.getBno(), board.getBdate(), board.getBwriter(), board.getBcontent());
            System.out.println("------------------------------------------------------------");
        }
    }

    // 3. 게시물 수정 view
    public void update(){
        System.out.print("수정할 게시물번호: "); int bno = scan.nextInt();
        scan.nextLine();
        System.out.print("수정할 내용: "); String bcontent = scan.nextLine();
        boolean result = bc.update( bno , bcontent );
        if( result ){ System.out.println("[안내] 게시물 수정 완료");}
        else{System.out.println("[경고] 게시물 수정 실패. 번호를 확인하세요.");}
    }

    // 4. 게시물 삭제 view
    public void delete(){
        System.out.print("삭제할 게시물 번호> ");     int bno = scan.nextInt();
        boolean result = bc.delete( bno );
        if( result ){ System.out.println("[안내] 게시물 삭제 완료");}
        else{System.out.println("[경고] 게시물 삭제 실패. 번호를 확인하세요.");}
    }

}//BoardView end
