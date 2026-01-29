package 종합.예제6.view;

import 종합.예제6.controller.BoardController;
import 종합.예제6.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {

    // 싱글톤 만들기
    // [1] 잠그기
    private BoardView(){}
    // [2] 상수 만들기
    private static final BoardView instance = new BoardView();
    // [3] 싱글톤
    public static BoardView getInstance(){
        return instance;
    }

    // MVC 패턴 흐름에 따라 controller 싱글톤 호출 (View -> Controller)
    private BoardController bc = BoardController.getInstance(); // new BoardController하면 새로운 애가 탄생... 안 돼! getter로 데려오자(호출)!

    // * 입력객체는 모든 메소드에서 사용할 예정이므로 지역변수 말고 메소드 밖에서 선언하자.
    public Scanner scan = new Scanner(System.in);


    // * 메인 (입출력) 화면
    public void indexView(){    // 최초 run과 같은 것.
        for(;;){
        System.out.println("========My community========");
        System.out.println("1. 게시물 쓰기  |  2. 게시물 출력");
        System.out.println("===============================");
        System.out.print("선택> ");
        Scanner scan = new Scanner(System.in);
        int ch = scan.nextInt();
        if(ch == 1){ writeView(); } // 만약에 1번 입력하면 쓰기 페이지로 이동
        else if(ch == 2){ printView(); } // 만약에 2번 입력하면 전체조회 페이지로 이동
        }
    }

    // 유지보수를 위해 이렇게 나눠둠.

    // 1] **등록 입력 화면 **     (출력 없기 때문에 void.)
    public void writeView( ){   // 쓰기
        // scan.nextLine(); -> 함수로 실행하기 때문에 의미없는 nextLine() 없어도 된대
        System.out.print("작성자: ");    String writer = scan.nextLine();
        System.out.print("내용: ");     String content = scan.nextLine();
        // 1) 컨트롤러에게 입력받은 content , writer 전달하여 결과 받아오기
        boolean result = bc.doPost(content, writer);
        // 2) 받은 결과에 따른 화면 출력해주기
        if( result ){System.out.println("[안내] 글쓰기 성공!");}
        else{System.out.println("[안내] 글쓰기 실패!");}
    }//m end


    // 2] ** 등록 출력 화면 **
    public void printView(){    // 출력
        // 1. 컨트롤러에게 모든 게시물 요청하고 결과를 받는다.
        ArrayList<BoardDto> boards = bc.doGet(); // vs. BoardDto[] boards = bc.doGet();
        // 2. 받은 결과를 모두 출력한다.  ArrayList는 가변(저장된 요소만)길이라서 null 체크 안 한다.
        for( BoardDto boardDto : boards ){
            System.out.printf("번호: %d\n작성자: %s\n내용: %s\n", boardDto.getNo() , boardDto.getWriter() , boardDto.getContent());
            System.out.println("---------------------------------");
        }
    }//m end
}
